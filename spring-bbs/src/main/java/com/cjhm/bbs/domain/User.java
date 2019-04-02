package com.cjhm.bbs.domain;

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

/**
 * @author CJHM
 *
 */
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 3527709835157984746L;

	@Id
    @Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idx;

	@Column
	private String name;

	@Column
	private String password;

	@Column
	private String email;

	@Column
	@CreationTimestamp
	private LocalDateTime createDate;

	@Column
	@UpdateTimestamp
	private LocalDateTime updateDate;

	public User() {

	}

	public User(Long idx, String name, String password, String email, LocalDateTime createDate,
			LocalDateTime updateDate) {
		super();
		this.idx = idx;
		this.name = name;
		this.password = password;
		this.email = email;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [idx=" + idx + ", name=" + name + ", password=" + password + ", email=" + email + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

}
