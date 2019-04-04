package com.cjhm.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {

	private Long createId;

	private LocalDateTime createDate;

	private Long updateId;

	private LocalDateTime updateDate;

	public void setCreateDate(String createDate) {
		this.createDate = LocalDateTime.parse(createDate);
	}

	public void setUpdateDate(String updateDate) {
		this.createDate = LocalDateTime.parse(updateDate);
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.createDate = updateDate;
	}
}
