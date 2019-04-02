package com.cjhm.bbs.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cjhm.bbs.domain.enums.BoardType;

/**
 * Created by KimYJ on 2017-07-12.
 */
@Entity
@Table(name="T_BOARD")
public class Board implements Serializable {

	private static final long serialVersionUID = -7283740362064565467L;

	@Id
    @Column
    @GeneratedValue
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
    public Board() {
    	
    }
	public Board(Long idx, String title, String subTitle, String content, BoardType boardType, LocalDateTime createDate,
			LocalDateTime updateDate, User user) {
		super();
		this.idx = idx;
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.boardType = boardType;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.user = user;
	}
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BoardType getBoardType() {
		return boardType;
	}
	public void setBoardType(BoardType boardType) {
		this.boardType = boardType;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
