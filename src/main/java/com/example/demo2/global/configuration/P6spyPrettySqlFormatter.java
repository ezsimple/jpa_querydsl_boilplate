package com.example.demo2.global.configuration;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
public class P6spyPrettySqlFormatter implements MessageFormattingStrategy {

    private final String basePackage = "com.example.demo2";
    private final List<String> filterStrings = Arrays.asList(new String[]{"<generated>", "doFilterInternal"});

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        sql = formatSql(category, sql);
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String callTrace = getCallStackTrace();
        return sdf.format(currentDate) + " | " + "OperationTime : " + elapsed + "ms" + sql + callTrace;
    }

    private String getCallStackTrace() {
        StringBuffer buf = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = stackTrace.length - 1; i >= 0; i--) {
            String trace = stackTrace[i].toString() + '\n';
            if (trace.contains(this.getClass().getName())) continue;
            if (okSkipFilter(trace)) continue;
            if (trace.startsWith(basePackage)) {
                buf.append('\t' + trace);
                // break; // 가장 마지막에 호출한 소스만 찾기
            }
        }
        return "\n\n" + buf;
    }

    private boolean okSkipFilter(String trace) {
        Boolean flag = filterStrings.stream()
                .map(o -> trace.contains(o))
                .findFirst().orElse(false);
        return flag;
    }

    private String formatSql(String category, String sql) {
        if (sql == null || sql.trim().equals("")) return sql;

        // Only format Statement, distinguish DDL And DML
        if (Category.STATEMENT.getName().equals(category)) {
            String tmpsql = sql.trim().toLowerCase(Locale.ROOT);
            if (tmpsql.startsWith("create") || tmpsql.startsWith("alter") || tmpsql.startsWith("comment")) {
                sql = FormatStyle.DDL.getFormatter().format(sql);
            } else {
                sql = FormatStyle.BASIC.getFormatter().format(sql);
                if (StringUtils.startsWith(tmpsql, "select")) {
                    sql = sql.replaceAll(" as [fc].*_[0-9a-zA-Z].*_", "");
                }
            }
            sql = "|\nHibernate:" + sql;
        }

        return sql;
    }
}
