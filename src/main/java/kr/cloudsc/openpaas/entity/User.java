package kr.cloudsc.openpaas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int userSeq;
	private String publicNm;
	private String mobileNum;
	private String email;
	private String passwd;
	private Date updateDt;
	private Date insertDt;
	private char status;
	private String changeNm;
	private String gearKind;
	private int gearCnt;
	private String secretKey;
	private String authCode;
	private String userType;
	private int loginFailCnt;	

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userSeq
	 * @param publicNm
	 * @param mobileNum
	 * @param email
	 * @param passwd
	 * @param updateDt
	 * @param insertDt
	 * @param status
	 * @param changeNm
	 * @param gearKind
	 * @param gearCnt
	 * @param secretKey
	 * @param authCode
	 * @param userType
	 * @param loginFailCnt
	 */
	public User(int userSeq, String publicNm, String mobileNum, String email,
			String passwd, Date updateDt, Date insertDt, char status,
			String changeNm, String gearKind, int gearCnt, String secretKey,
			String authCode, String userType, int loginFailCnt) {
		super();
		this.userSeq = userSeq;
		this.publicNm = publicNm;
		this.mobileNum = mobileNum;
		this.email = email;
		this.passwd = passwd;
		this.updateDt = updateDt;
		this.insertDt = insertDt;
		this.status = status;
		this.changeNm = changeNm;
		this.gearKind = gearKind;
		this.gearCnt = gearCnt;
		this.secretKey = secretKey;
		this.authCode = authCode;
		this.userType = userType;
		this.loginFailCnt = loginFailCnt;
	}
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="user_seq")
	public int getUserSeq() {
		return userSeq;
	}

	@SuppressWarnings("unused")
	private void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	@Column(name="public_nm")
	public String getPublicNm() {
		return publicNm;
	}

	public void setPublicNm(String publicNm) {
		this.publicNm = publicNm;
	}

	@Column(name="mobile_num")
	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="passwd")
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_dt")
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_dt")
	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}

	
	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	@Column(name="change_nm")
	public String getChangeNm() {
		return changeNm;
	}

	public void setChangeNm(String changeNm) {
		this.changeNm = changeNm;
	}
	@Column(name="gear_kind")
	public String getGearKind() {
		return gearKind;
	}

	public void setGearKind(String gearKind) {
		this.gearKind = gearKind;
	}

	@Column(name="gear_cnt")
	public int getGearCnt() {
		return gearCnt;
	}

	public void setGearCnt(int gearCnt) {
		this.gearCnt = gearCnt;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name="login_fail_cnt")
	public int getLoginFailCnt() {
		return loginFailCnt;
	}

	public void setLoginFailCnt(int loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}
	
	

}
