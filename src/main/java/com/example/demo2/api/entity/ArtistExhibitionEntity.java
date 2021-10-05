package com.example.demo2.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "t_artist_exhibition")
public class ArtistExhibitionEntity implements Serializable {   // 아티스트 기획전 마스터

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_EXHIBITION_INDEX")
    private Long exhibitionIndex;       // 기획전 마스터 INDEX

    @Column(name = "F_MEMBER_NO")
    private Long memberNo;              // 회원 번호

    @Column(name = "F_EXHIBITION_NAME")
    private String exhibitionName;      // 기획전 명

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_REGIST_DATE")
    private LocalDateTime registDate;   // 등록 일시

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "F_MODIFY_DATE")
    private LocalDateTime modifyDate;   // 수정 일시

    //    // @JsonManagedReference // @JsonIgnore 사용으로 불필요한 어노테이션이다.
    @JsonIgnore // 직렬화에서 배제하기 (주의: FetchType.LAZY 동작 안하는 현상 보완)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artistExhibitionEntity", cascade = {CascadeType.ALL})
    private List<ArtistExhibitionProductEntity> artistExhibitionProductList;

}
