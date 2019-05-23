package com.cjhm.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "T_BOARD_ARTICLE")
@Entity
public class Article implements Serializable {

	private static final long serialVersionUID = 4185372500560317867L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long articleId;

	@Column
	private Long refarticleId;

	@Column
	private Long uparticleId;

	@Column
	@Builder.Default
	private Long indent =1L;

	@Column
	private Long boardId;

	@Column
	private String title;

	@Column
	private String content;

	@Column
	private String contentFileId;

	@Column
	@Builder.Default
	private int sortno = 1;

	@Column
	private Long userId;

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

	@ManyToOne(targetEntity=Board.class,fetch=FetchType.LAZY)
	@JoinColumn(name="boardId",insertable=false,updatable=false)
	Board board;

	@OneToMany(targetEntity=Comment.class,mappedBy="article")
	@Builder.Default
	List<Comment> commentList = new ArrayList<Comment>();
	
	public void addIndent() {
		this.indent++;
	}
}
