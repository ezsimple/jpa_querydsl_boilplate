package com.example.demo2.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo2.global.crypt.CryptoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "T_MEMBER_SETTLE")
public class MemberSettleEntity {
    @Id
    @Column(name="F_MEMBER_NO")
    private Long memberNo;    // 회원 번호

    @Column(name="F_COMPANY_TYPE_CODE")
    private String companyTypeCode;    // 사업자 유형 코드(F_TYPE_CODE:109)

    @Column(name="F_BANK_CODE")
    private String bankCode;    // 은행 코드(F_TYPE_CODE:145)

    @Column(name="F_ACCOUNT_HOLDER_NAME")
    private String accountHolderName;    // 예금주 명

    @Column(name="F_ACCOUNT_NO")
    private String accountNo;    // 계좌 번호(암호화)

    @Column(name="F_BUSINESS_CERTIFY_FILE_PATH")
    private String businessCertifyFilePath;    // 사업자등록증 파일 경로

    @Column(name="F_BUSINESS_CERTIFY_ORG_FILE_NAME")
    private String businessCertifyOrgFileName;    // 사업자등록증 오리진 파일 명

    @Column(name="F_ACCOUNT_FILE_PATH")
    private String accountFilePath;    // 입금계좌번호 통장 파일 경로

    @Column(name="F_ACCOUNT_ORG_FILE_NAME")
    private String accountOrgFileName;    // 입금계좌번호 오리진 통장 파일 명

    @Column(name="F_FOREIGNER_YN")
    private String foreignerYn;    // 외국인 여부(Y:외국인, N:내국인)

    @Column(name="F_REAL_NAME")
    private String realName;    // 실명 인증 성명

    @Column(name="F_REAL_MOBILE_PHONE1")
    private String realMobilePhone1;    // 실명 인증 휴대폰 번호1

    @Column(name="F_REAL_MOBILE_PHONE2")
    private String realMobilePhone2;    // 실명 인증 휴대폰 번호2

    @Column(name="F_REAL_MOBILE_PHONE3")
    private String realMobilePhone3;    // 실명 인증 휴대폰 번호3

    @Column(name="F_REAL_CI")
    private String realCi;    // 실명 인증 CI

    @Column(name="F_REAL_DI")
    private String realDi;    // 실명 인증 DI

    @Column(name="F_COMPANY_NUMBER")
    private String companyNumber;    // 사업자등록번호

    @Column(name="F_RESIDENT_NUMBER")
    private String residentNumber;    // 주민등록번호(암호화)

    @Column(name="F_SETTLE_EMAIL")
    private String settleEmail;    // 정산 이메일

    @Column(name="F_COMPANY_NAME")
    private String companyName;    // 회사명

    @Column(name="F_CEO_NAME")
    private String ceoName;    // 대표자명

    @Column(name="F_POST_CODE")
    private String postCode;    // 우편번호

    @Column(name="F_BASIC_ADDRESS")
    private String basicAddress;    // 기본 주소

    @Column(name="F_DETAIL_ADDRESS")
    private String detailAddress;    // 상세 주소

    @Column(name="F_BUSINESS_TYPE")
    private String businessType;    // 업태

    @Column(name="F_BUSINESS_KIND")
    private String businessKind;    // 종목

    @LastModifiedBy
    @Column(name="F_MODIFY_ID")
    private String modifyId;    // 수정자 아이디(관리자 ID)

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @Column(name="F_MODIFY_DATE")
    private LocalDateTime modifyDate;    // 수정 일시

    @Transient
    private MemberMasterEntity memberMasterEntity;

    @Transient
    private String bankCodeValue;    // 은행 코드(F_TYPE_CODE:145) 값

    @Transient
    private String companyTypeCodeValue;    // 사업자 유형 코드(F_TYPE_CODE:109) 값

    @Transient
    private String adminMemo;//관리자 메모

    //계좌번호 복호화
    public String getAccountNo() {
        return CryptoUtil.decrypt(this.accountNo);
    }

    //주민등록번호 보호화
    public String getResidentNumber() {
        return CryptoUtil.decrypt(this.residentNumber);
    }

    public String getRealMobilePhone() {
        String retVal = "";
        if(StringUtils.isNotEmpty(this.realMobilePhone1) && StringUtils.isNotEmpty(this.realMobilePhone2) && StringUtils.isNotEmpty(this.realMobilePhone3)) {
            retVal = retVal.concat(this.realMobilePhone1).concat("-").concat(this.realMobilePhone2).concat("-").concat(this.realMobilePhone3);
        }
        return retVal;
    }
}
