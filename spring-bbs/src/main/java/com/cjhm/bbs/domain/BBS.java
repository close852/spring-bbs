package com.cjhm.bbs.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cjhm.bbs.domain.enums.BoardType;
import com.cjhm.board.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by KimYJ on 2017-07-12.
 */
/**
 * @author CJHM
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="T_BBS")
public class BBS extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7283740362064565467L;

	@Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @OneToOne(fetch= FetchType.LAZY)
    private User user;
    
}
