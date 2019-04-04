package com.cjhm.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="T_BOARD")
public class Board extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -1828016430242958321L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long boardId;
	
	@Column
	private String msgId;
	
	private String name;

	@Column
	private Long categoryId;
	
	@Column
	private String useYn;
	
	@Column
	private String BoardType;
	
	@Column
	private String treeId;
	
	@Column
	private String upboardId;
	
	@Column
	private int depth;
	
	@Column
	private int sortno;
	
	@Column
	private Long createId;
	
	@Column
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column
	private Long updateId;
	
	@Column
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
}
