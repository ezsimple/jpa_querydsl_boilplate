package com.example.demo2.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@ToString(callSuper = true)
@Table(name = "T_ART_PRODUCT")
public class ArtProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ART_PRODUCT_INDEX")
    private Long artProductIndex;    // 아트워크 상품 코드

    @Column(name = "F_PRODUCT_CODE")
    private String productCode;    // 상품 코드

    @Column(name = "F_ARTWORK_INDEX")
    private Long artworkIndex;    // 작품 INDEX

    @Column(name = "F_MEMBER_NO")
    private Long memberNo;    // 회원 번호
//
//	@Column(name="F_ARTWORK_IMAGE_INDEX")
//	private Long artworkImageIndex;    // 아트워크 이미지 INDEX

    @Column(name = "F_MARK_UP")
    private BigDecimal markUp;    // 상품 마진 율

    @Column(name = "F_SELL_STATUS_CODE")
    private String sellStatusCode;    // 판매 상태 코드(F_TYPE_CODE:136)

    @Column(name = "F_PRIMARY_COLOR")
    private String primaryColor;    // 대표 색상

    @Column(name = "F_VERIFY_STATUS")
    private String verifyStatus; // 상품등록이후 편집정보 검증 여부 ( S: 시작 , X : 에러, E : 완료)

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_REGIST_DATE")
    private LocalDateTime registDate;    // 등록 일시

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_MODIFY_DATE")
    private LocalDateTime modifyDate;    // 수정 일시

    @Column(name = "F_PRIMARY_PRODUCT_CODE")
    private String primaryProductCode; // 대표 상품 코드

    @Column(name = "F_DIRECTION_CODE")
    private String directionCode; // 디렉션 코드

    @Column(name = "F_ARTWORK_VERSION_INDEX")
    private Long artworkVersionIndex; // 아트웍 최종 버전 이력 INDEX

    @Column(name = "F_AMASS_ORDER_COUNT")
    private Long amassOrderCount; // 누적 판매 수

    @Column(name = "F_AMASS_LIKE_COUNT")
    private Long amassLikeCount; // 누적 라이크 수

    @Column(name = "F_AMASS_REVIEW_COUNT")
    private Long amassReviewCount; // 누적 리뷰 수

//	@Column(name = "F_PRODUCT_COST")
//	private BigDecimal productCost; // 상품 원가 상품공급가

    @Column(name = "F_SORT_ORDER")
    private Integer sortOrder; // 정렬 순서 : 셀럽 그라운드 안에서 AI 추천순

    @Column(name = "F_DELETE_YN")
    private String deleteYn; // 상품 삭제 여부 : 셀럽 X, 오라운더 X

    @Column(name = "F_OPEN_YN")
    private String openYn; // 상품 공개 여부 : 셀럽 O, 오라운더 X

    @Column(name = "F_SEARCH_PRICE_JPY")
    private BigDecimal searchPriceJpy; // 조회용 상품 판매가 JPY

    @Column(name = "F_SEARCH_PRICE_KRW")
    private BigDecimal searchPriceKrw; // 조회용 상품 판매가 KRW

    @Column(name = "F_SEARCH_PRICE_USD")
    private BigDecimal searchPriceUsd; // 조회용 상품 판매가 USD

    @Column(name = "F_PRINT_POSITION_CODE")
    private String printPositionCode; // 출력 위치 코드

}
