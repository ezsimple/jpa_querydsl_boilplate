package com.example.demo2.api.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "T_SETTLE_MASTER")
public class SettleMasterEntity implements Serializable {

    @Id
    @Column(name = "F_SETTLE_INDEX")
    private Long settleIndex;                        // 정산 INDEX

    @ManyToOne
    @JoinColumn(name = "F_MEMBER_NO")
    private MemberSettleEntity memberSettleEntity; // 회원 번호 (FK)

    @ManyToOne
    @JoinColumn(name="F_ORDER_NO")
    private OrderEntity orderEntity; // 주문 번호 (FK)

    @ManyToOne
    @JoinColumn(name="F_ORDER_ITEM_INDEX")
    private OrderItemEntity orderItemEntity; // 주문 아이템 INDEX (FK)

    @ManyToOne
    @JoinColumn(name="F_ART_PRODUCT_INDEX")
    private ArtProductEntity artProductEntity; // 아트웍 상품 코드 (FK)

    @Column(name = "F_SETTLE_NO")
    private String settleNo; // 정산 번호

    @Column(name = "F_SETTLE_START_DATE")
    private String settleStartDate; // 정산 대상 시작 일

    @Column(name = "F_SETTLE_END_DATE")
    private String settleEndDate; // 정산 대상 마감 일

    @Column(name = "F_SETTLE_CODE")
    private String settleCode; // 정산 마감 코드(F_TYPE_CODE:186), 186001: 정산확정, 186002: 정산완료, 186003: 정산보류, 186004: 정산대기

    @Column(name = "F_DEPOSIT_CODE")
    private String depositCode; // 입금 수단 코드(F_TYPE_CODE:187), 187001: 국내계좌, 187002: 페이팔

    @Column(name = "F_SETTLE_QUANTITY")
    private Long settleQuantity; // 상품 수량

    @Column(name = "F_SELL_AMOUNT_KRW")
    private BigDecimal sellAmountKrw; // 판매 금액 KRW

    @Column(name = "F_SELL_AMOUNT_JPY")
    private BigDecimal sellAmountJpy; // 판매 금액 JPY

    @Column(name = "F_SELL_AMOUNT_USD")
    private BigDecimal sellAmountUsd; // 판매 금액 USD

    @Column(name = "F_COST_AMOUNT_KRW")
    private BigDecimal costAmountKrw; // 공급 금액 KRW

    @Column(name = "F_COST_AMOUNT_JPY")
    private BigDecimal costAmountJpy; // 공급 금액 JPY

    @Column(name = "F_COST_AMOUNT_USD")
    private BigDecimal costAmountUsd; // 공급 금액 USD

    @Column(name = "F_ARTIST_COUPON_AMOUNT_KRW")
    private BigDecimal artistCouponAmountKrw; // 아티스트 쿠폰 할인 금액 KRW

    @Column(name = "F_ARTIST_COUPON_AMOUNT_JPY")
    private BigDecimal artistCouponAmountJpy; // 아티스트 쿠폰 할인 금액 JPY

    @Column(name = "F_ARTIST_COUPON_AMOUNT_USD")
    private BigDecimal artistCouponAmountUsd; // 아티스트 쿠폰 할인 금액 USD

    @Column(name = "F_ETC_COUPON_AMOUNT_KRW")
    private BigDecimal etcCouponAmountKrw;    // 기타 쿠폰 할인 금액 KRW

    @Column(name = "F_ETC_COUPON_AMOUNT_JPY")
    private BigDecimal etcCouponAmountJpy; // 기타 쿠폰 할인 금액 JPY

    @Column(name = "F_ETC_COUPON_AMOUNT_USD")
    private BigDecimal etcCouponAmountUsd; // 기타 쿠폰 할인 금액 USD

    @Column(name = "F_SELL_PROFIT_KRW")
    private BigDecimal sellProfitKrw; // 판매 수익 KRW

    @Column(name = "F_SELL_PROFIT_JPY")
    private BigDecimal sellProfitJpy; // 판매 수익 JPY

    @Column(name = "F_SELL_PROFIT_USD")
    private BigDecimal sellProfitUsd; // 판매 수익 USD

    @Column(name = "F_DEDUCT_AMOUNT_KRW")
    private BigDecimal deductAmountKrw; // 공제 금액 KRW

    @Column(name = "F_DEDUCT_AMOUNT_JPY")
    private BigDecimal deductAmountJpy; // 공제 금액 JPY

    @Column(name = "F_DEDUCT_AMOUNT_USD")
    private BigDecimal deductAmountUsd; // 공제 금액 USD

    @Column(name = "F_SETTLE_AMOUNT_KRW")
    private BigDecimal settleAmountKrw; // 정산 금액 KRW

    @Column(name = "F_SETTLE_AMOUNT_JPY")
    private BigDecimal settleAmountJpy; // 정산 금액 JPY

    @Column(name = "F_SETTLE_AMOUNT_USD")
    private BigDecimal settleAmountUsd; // 정산 금액 USD

    @Column(name = "F_SETTLE_CONFIRM_DATE")
    private LocalDateTime settleConfirmDate; // 정산 확정 일시

    @Column(name = "F_SETTLE_COMPLETE_DATE")
    private LocalDateTime settleCompleteDate; // 정산 완료 일시

    @Column(name = "F_SETTLE_ID")
    private String settleId; // 정산 완료 처리자 아이디

    @Column(name = "F_SETTLE_HOLD_DATE")
    private LocalDateTime settleHoldDate; // 정산 보류 일시

    @Column(name = "F_SETTLE_HOLD_ID")
    private String settleHoldId; // 정산 보류 처리자 아이디

    @Column(name = "F_EXCHANGE_RATE_JPY")
    private BigDecimal exchangeRateJpy; // 환율 JPY

    @Column(name = "F_EXCHANGE_RATE_USD")
    private BigDecimal exchangeRateUsd; // 환율 USD

    @Column(name = "F_SETTLE_HOLD_CODE")
    private String settleHoldCode; // 정산 보류 코드(F_TYPE_CODE:188), 188001: 정산계좌 인증 실패, 188002: 저작권 및 이용약관 위배, 188003: 성인용 콘텐츠 공개 처리 위배, 188004: 기타

    @Column(name = "F_SETTLE_HOLD_REASON")
    private String settleHoldReason; // 정산 보류 사유

    @Column(name = "F_SETTLE_PAY_CODE")
    private String settlePayCode; // 정산 지급 코드(F_TYPE_CODE:189), 189001: 정상지급, 189002: 이월
}