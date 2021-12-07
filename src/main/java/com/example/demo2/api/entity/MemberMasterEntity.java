package com.example.demo2.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "T_MEMBER_MASTER")
public class MemberMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_MEMBER_NO")
    private Long memberNo;    // 회원 번호

    @Column(name = "F_MEMBER_ID")
    private String memberId;    // 회원 아이디

    @Column(name = "F_MEMBER_STATUS_CODE")
    private String memberStatusCode;    // 회원 상태 코드(F_TYPE_CODE:100)

    @Column(name = "F_PASSWORD")
    private String password;    // 비밀 번호

    @Column(name = "F_MEMBER_NAME")
    private String memberName;    // 회원 성명

    @Column(name = "F_JOIN_MEDIA_CODE")
    private String joinMediaCode;    // 가입 매체 코드(F_TYPE_CODE:101)

    @Column(name = "F_JOIN_TYPE_CODE")
    private String joinTypeCode;    // 가입 타입 코드(F_TYPE_CODE:102)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_LAST_LOGIN_DATE")
    private LocalDateTime lastLoginDate;    // 최종 로그인 일시

    @Column(name = "F_BUYER_GRADE_CODE")
    private String buyerGradeCode;    // 구매 등급 코드(F_TYPE_CODE:103)

    @Column(name = "F_ARTIST_GRADE_CODE")
    private String artistGradeCode;    // 판매 등급 코드(F_TYPE_CODE:104)

    @Column(name = "F_JOIN_AREA_CODE")
    private String joinAreaCode;    // 가입 지역 코드(F_TYPE_CODE:105)-회원가입(주문, 쿠폰, 통화, 결제수단)

    @Column(name = "F_USE_AREA_CODE")
    private String useAreaCode;    // 이용 지역 코드(F_TYPE_CODE:105)-이용 언어

    @Column(name = "F_MOBILE_PHONE1")
    private String mobilePhone1;    // 휴대폰 번호1

    @Column(name = "F_MOBILE_PHONE2")
    private String mobilePhone2;    // 휴대폰 번호2

    @Column(name = "F_MOBILE_PHONE3")
    private String mobilePhone3;    // 휴대폰 번호3

    @Column(name = "F_EMAIL")
    private String email;    // 이메일 아이디

    @Column(name = "F_EMAIL_RECIVE_YN")
    private String emailReciveYn;    // 이메일 수신 여부(Y:수신동의, N:수신비동의)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_EMAIL_RECIVE_YN_DATE")
    private LocalDateTime emailReciveYnDate;    // 이메일 수신 여부 일시

    @Column(name = "F_SMS_RECIVE_YN")
    private String smsReciveYn;    // SMS 수신 여부(Y:수신동의, N:수신비동의)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_SMS_RECIVE_YN_DATE")
    private LocalDateTime smsReciveYnDate;    // SMS 수신 여부 일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_JOIN_DATE")
    private LocalDateTime joinDate;    // 가입 일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_DORMANT_DATE")
    private LocalDateTime dormantDate;    // 휴면 등록 일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_BLACK_DATE")
    private LocalDateTime blackDate;    // 블랙 등록 일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_WITHDRAW_DATE")
    private LocalDateTime withdrawDate;    // 탈퇴 일시

    @Column(name = "F_ARTIST_YN")
    private String artistYn;    // 아티스트 여부(Y:아티스트, N:비아티스트)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_ARTIST_CERTIFY_DATE")
    private LocalDateTime artistCertifyDate;    // 아티스트 인증 일시

    @Column(name = "F_SPECIALLY_ARTIST_YN")
    private String speciallyArtistYn;    // 전문 아티스트 여부(Y:전문, N:일반)

    @Column(name = "F_SPECIALLY_ARTIST_MARGIN")
    private BigDecimal speciallyArtistMargin;    // 전문 아티스트 마진율

    @Column(name = "F_GA_ID")
    private String gaId;    // Google Analytics ID

    @Column(name = "F_JOIN_IP")
    private String joinIp;    // 회원 가입 IP Address

    @Column(name = "F_PROFILE_IMAGE_FILE_PATH")
    private String profileImageFilePath;    // 프로필 이미지 파일 경로

    @Column(name = "F_PROFILE_IMAGE_ORG_FILE_NAME")
    private String profileImageOrgFileName;    // 프로필 이미지 오리진 파일 명

    @Column(name = "F_LAST_HOLD_POINT")
    private Long lastHoldPoint;    // 최종 보유 포인트

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_PASSWORD_MODIFY_DATE")
    private LocalDateTime passwordModifyDate; // 최종 비밀번호 변경 일시

    @LastModifiedBy
    @Column(name = "F_MODIFY_ID")
    private String modifyId;    // 수정자 아이디(관리자 ID)

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_MODIFY_DATE")
    private LocalDateTime modifyDate;    // 수정 일시

    @Column(name = "F_WITHDRAW_CODE")
    private String withdrawCode; // 탈퇴 사유 코드(F_TYPE_CODE:175)

    @Column(name = "F_WITHDRAW_REASON")
    private String withdrawReason; // 탈퇴 사유

    public String getMobilePhone() {
        String retVal = "";
        if (StringUtils.isNotEmpty(this.mobilePhone1) && StringUtils.isNotEmpty(this.mobilePhone2) && StringUtils.isNotEmpty(this.mobilePhone3)) {
            retVal = retVal.concat(this.mobilePhone1).concat("-").concat(this.mobilePhone2).concat("-").concat(this.mobilePhone3);
        }
        return retVal;
    }

}
