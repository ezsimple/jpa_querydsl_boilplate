package com.example.demo2.api.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "t_coupon_random")
public class CouponRandomEntity implements Persistable<String> {
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="F_COUPON_RANDOM_INDEX")
    // private Long couponRandomIndex;    // 쿠폰 랜덤 INDEX

    @Id
    @Column(name = "F_RANDOM_COUPON_NO")
    private String randomCouponNo;    // 랜덤 쿠폰 번호

    @Column(name = "F_COUPON_INDEX")
    private Long couponIndex;    // 마스터 쿠폰 INDEX (FK)

    @Column(name = "F_MEMBER_NO")
    private Long memberNo;    // 회원 번호

    @Column(name = "F_COUPON_REGIST_YN")
    private String couponRegistYn;    // 쿠폰 등록 여부(Y:등록된 쿠폰 번호, N:미등록된 쿠폰 번호)

    @CreatedBy
    @Column(name = "F_COUPON_REGIST_DATE")
    private LocalDateTime couponRegistDate;    // 쿠폰 등록 일시

    @Transient
    boolean isNew = true;

    @Override
    public String getId() {
        return randomCouponNo;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }

    @PrePersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }
}
