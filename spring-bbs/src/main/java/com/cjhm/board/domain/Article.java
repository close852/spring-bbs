package com.cjhm.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	private Long indent;

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

	@OneToOne(fetch = FetchType.LAZY)
	Board board;

	public void addIndent() {
		this.indent++;
	}
}
