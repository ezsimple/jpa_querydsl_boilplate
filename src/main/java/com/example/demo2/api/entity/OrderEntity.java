package com.example.demo2.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "t_order_master")
@NamedStoredProcedureQuery(
        name = "proc_order_no",
        procedureName = "PROC_ORDER_NO",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class)
        })
public class OrderEntity {

    @Id
    @Column(name = "F_ORDER_NO")
    private String orderNo;    // 주문 번호

    @Column(name = "F_ORG_ORDER_NO")
    private String orgOrderNo;    // 원 주문 번호(교환)

    @Column(name = "F_MEMBER_NO")
    private Long memberNo;    // 회원 번호

    @Column(name = "F_ORDER_STATUS_CODE")
    private String orderStatusCode;    // 주문 상태 코드(F_TYPE_CODE:123)

    @Column(name = "F_ORDER_AREA_CODE")
    private String orderAreaCode;    // 주문 지역 코드(F_TYPE_CODE:105)

    @Column(name = "F_ORDER_MEDIA_CODE")
    private String orderMediaCode;    // 주문 매체 코드(F_TYPE_CODE:101)

    @Column(name = "F_PAYMENT_TYPE_CODE")
    private String paymentTypeCode;    // 결제 수단 코드(F_TYPE_CODE:126)

    @Column(name = "F_PAYMENT_STATUS_CODE")
    private String paymentStatusCode;    // 결제 상태 코드(F_TYPE_CODE:124)

    @Column(name = "F_MOBILE_DEVICE_CODE")
    private String mobileDeviceCode;    // 모바일 디바이스 코드(F_TYPE_CODE:154)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @CreatedDate
    @Column(name = "F_ORDER_FINISH_DATE")
    private LocalDateTime orderFinishDate;    // 주문 완료 일시

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_PAYMENT_FINISH_DATE")
    private LocalDateTime paymentFinishDate;    // 결제 완료 일시

    @Column(name = "F_EXCHANGE_RATE_JPY")
    private BigDecimal exchangeRateJpy;    // 주문 환율 JPY

    @Column(name = "F_EXCHANGE_RATE_USD")
    private BigDecimal exchangeRateUsd;    // 주문 환율 USD

    @Column(name = "F_TOTAL_PAYMENT_AMOUNT")
    private BigDecimal totalPaymentAmount;    // 총 결제 금액

    @Column(name = "F_USE_POINT")
    private Long usePoint;    // 사용 포인트

    @Column(name = "F_USE_POINT_AMOUNT")
    private BigDecimal usePointAmount;    // 사용 포인트 금액

    @Column(name = "F_SHIPPING_AMOUNT")
    private BigDecimal shippingAmount;    // 배송비

    @Column(name = "F_CART_COUPON_INDEX")
    private Long cartCouponIndex;    // 장바구니 쿠폰 번호

    @Column(name = "F_CART_MEMBER_COUPON_INDEX")
    private Long cartMemberCouponIndex;    // 장바구니 회원 쿠폰 번호

    @Column(name = "F_CART_COUPON_AMOUNT")
    private BigDecimal cartCouponAmount;    // 장바구니 쿠폰 사용 금액

    @Column(name = "F_SHIPPING_COUPON_INDEX")
    private Long shippingCouponIndex;    // 무료 배송 쿠폰 번호

    @Column(name = "F_SHIPPING_MEMBER_COUPON_INDEX")
    private Long shippingMemberCouponIndex;    // 무료 배송 회원 쿠폰 번호

    @Column(name = "F_SHIPPING_COUPON_AMOUNT")
    private BigDecimal shippingCouponAmount;    // 무료 배송 쿠폰 사용 금액

    @Column(name = "F_FREE_SHIPPING_YN")
    private String freeShippingYn;    // 무료 배송 적용 여부(Y:조건부 무료배송(50,000원 이상) 적용, N:조건부 무료배송 미적용)

    @Column(name = "F_TAX_BILL_YN")
    private String taxBillYn;    // 세금 계산서 신청 여부(Y:세금계산서 신청, N:세금계산서 미신청)

    @Column(name = "F_TOTAL_PAYMENT_REMAIN_AMOUNT")
    private BigDecimal totalPaymentRemainAmount;    // 총 환불 후 결제 잔액

    @Column(name = "F_TOTAL_POINT_REMAIN")
    private Long totalPointRemain;    // 환불 후 사용 포인트

    @Column(name = "F_TOTAL_POINT_REMAIN_AMOUNT")
    private BigDecimal totalPointRemainAmount;    // 환불 후 사용 포인트 잔액

    @Column(name = "F_REFUND_SHIPPING_AMOUNT")
    private BigDecimal refundShippingAmount;    // 환불 후 배송비

    @Column(name = "F_REFUND_SHIPPING_COUPON_AMOUNT")
    private BigDecimal refundShippingCouponAmount;    // 환불 후 무료 배송 쿠폰 금액

    @Column(name = "F_REFUND_CART_COUPON_AMOUNT")
    private BigDecimal refundCartCouponAmount;    // 환불 후 무료 배송 쿠폰 금액

}
