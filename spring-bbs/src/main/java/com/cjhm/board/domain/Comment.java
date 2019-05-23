package com.cjhm.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "T_BOARD_ARTICLE_COMMENT")
public class Comment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -915327229043237621L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;

	@Column
	private Long refcommentId;

	@Column
	private Long upcommentId;

	@Column
	private String content;

	@Column
	private int sortno;

	@Column
	private int indent;

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
	
	@ManyToOne(targetEntity=Article.class)
	@JoinColumn(name="articleId")
	Article article;
	
	public void addArticle(Article article) {
		this.article=article;
		if(article!=null && !article.getCommentList().contains(this)) {
			article.getCommentList().add(this);
		}
	}
}
