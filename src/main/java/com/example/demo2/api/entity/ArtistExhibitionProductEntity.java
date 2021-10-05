package com.example.demo2.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "t_artist_exhibition_product")
public class ArtistExhibitionProductEntity implements Serializable {    // 아티스트 기획전 마스터

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_EXHIBITION_PRODUCT_INDEX")
    private Long exhibitionProductIndex;        // 기획전 상품 INDEX

    @Column(name = "F_EXHIBITION_INDEX")
    private Long exhibitionIndex;               // 기획전 마스터 INDEX

    @Column(name = "F_ART_PRODUCT_INDEX")
    private Long artProductIndex;             // 아트웍 상품 코드

    // @JsonBackReference // @JsonIgnore 사용으로 불필요한 어노테이션이다.
    @JsonIgnore // 직렬화에서 배제하기 (주의: FetchType.LAZY 동작 안하는 현상 보완)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_EXHIBITION_INDEX", insertable = false, updatable = false)
    private ArtistExhibitionEntity artistExhibitionEntity;

}
