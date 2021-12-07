package com.example.demo2.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "t_order_item")
public class OrderItemEntity {

    @Id
    @Column(name = "F_ORDER_ITEM_INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemIndex;    // 주문 아이템 INDEX

    @Column(name = "F_ART_PRODUCT_INDEX")
    private Long artProductIndex;    // 아트웍 상품 코드

    @Column(name = "F_PRODUCT_CODE")
    private String productCode;    // 상품 코드

    @Column(name = "F_MEMBER_NO")
    private Long memberNo;    // 회원 번호(아티스트)

    @Column(name = "F_ORDER_ITEM_SEQUENCE")
    private Integer orderItemSequence;    // 주문 아이템 순번

    @Column(name = "F_ORDER_STATUS_CODE")
    private String orderStatusCode;    // 주문 상태 코드(F_TYPE_CODE:123)

    @Column(name = "F_SETTLE_STATUS_CODE")
    private String settleStatusCode;    // 정산 상태 코드(F_TYPE_CODE:132)

    @Column(name = "F_MARK_UP")
    private BigDecimal markUp;    // 마진 율

    @Column(name = "F_PRODUCT_COST")
    private BigDecimal productCost;    // 상품 원가/단가

    @Column(name = "F_ORDER_QUANTITY")
    private Integer orderQuantity;    // 주문 수량

    @Column(name = "F_RETURN_QUANTITY")
    private Integer returnQuantity;    // 반품 수량

    @Column(name = "F_EXCHANGE_QUANTITY")
    private Integer exchangeQuantity;    // 교환 수량

    @Column(name = "F_PRODUCT_SELL_PRICE")
    private BigDecimal productSellPrice;    // 상품 판매가(옵션불포함)

    @Column(name = "F_TOTAL_SELL_PRICE")
    private BigDecimal totalSellPrice;    // 총 판매가(상품 판매가 + 옵션 판매가)

    @Column(name = "F_PRODUCT_COUPON_INDEX")
    private Long productCouponIndex;    // 상품 쿠폰 번호

    @Column(name = "F_PRODUCT_MEMBER_COUPON_INDEX")
    private Long productMemberCouponIndex;    // 상품 회원 쿠폰 번호

    @Column(name = "F_PRODUCT_COUPON_AMOUNT")
    private BigDecimal productCouponAmount;    // 상품 쿠폰 사용 금액

    @Column(name = "F_ORDER_CONFIRM_DATE")
    private LocalDateTime orderConfirmDate;    // 구매 확정 일시

    @Column(name = "F_SHIPPING_FINISH_DATE")
    private LocalDateTime shippingFinishDate;    // 배송 완료 일시

    @Column(name = "F_SITTLE_FINISH_DATE")
    private LocalDateTime sittleFinishDate;    // 정산 완료 일시

    @Column(name = "F_ART_PRODUCT_NAME")
    private String artProductName;    // 주문 상품 명

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_SHIPPING_INVOICE_REGIST_DATE")
    private LocalDateTime shippingInvoiceRegistDate;    // 송장 등록 일시

    @ManyToOne
    @JoinColumn(name = "F_ORDER_NO")
    private OrderEntity orderEntity;  // 주문 엔티티

}
