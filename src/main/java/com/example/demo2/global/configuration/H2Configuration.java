//package com.example.demo2.global.configuration;
//
//import org.h2.tools.Server;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//// intellij의 query console을 사용해 보자.
//@Configuration
//public class H2Configuration {
//    @Bean
//    @ConfigurationProperties("spring.datasource.hikari")
//    public DataSource dataSource() throws SQLException {
//        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
//        return new com.zaxxer.hikari.HikariDataSource();
//    }
//}
