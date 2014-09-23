/**
 * 
 */
package kr.cloudsc.openpaas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.cloudsc.openpaas.model
 * User.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 9. 23.
 * @Version : 
 */

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207348772947838036L;
	
	
	private int user_seq;	
	private String public_nm;
	private String mobile_num;
	private String email;
	private String passwd;
	private Date update_dt;
	private Date insert_dt;
	private char status;
	private String charge_nm;
	private String gear_kind;	
	private int gear_cnt;
	private String secretkey;
	private String authcode;
	private String usertype;
	private int login_fail_cnt;

	

	
	
	public int getUser_seq() {
		return user_seq;
	}




	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}




	public String getPublic_nm() {
		return public_nm;
	}




	public void setPublic_nm(String public_nm) {
		this.public_nm = public_nm;
	}




	public String getMobile_num() {
		return mobile_num;
	}




	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPasswd() {
		return passwd;
	}




	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}




	public Date getUpdate_dt() {
		return update_dt;
	}




	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}




	public Date getInsert_dt() {
		return insert_dt;
	}




	public void setInsert_dt(Date insert_dt) {
		this.insert_dt = insert_dt;
	}




	public char getStatus() {
		return status;
	}




	public void setStatus(char status) {
		this.status = status;
	}




	public String getCharge_nm() {
		return charge_nm;
	}




	public void setCharge_nm(String charge_nm) {
		this.charge_nm = charge_nm;
	}




	public String getGear_kind() {
		return gear_kind;
	}




	public void setGear_kind(String gear_kind) {
		this.gear_kind = gear_kind;
	}




	public int getGear_cnt() {
		return gear_cnt;
	}




	public void setGear_cnt(int gear_cnt) {
		this.gear_cnt = gear_cnt;
	}




	public String getSecretkey() {
		return secretkey;
	}




	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}




	public String getAuthcode() {
		return authcode;
	}




	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}




	public String getUsertype() {
		return usertype;
	}




	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}




	public int getLogin_fail_cnt() {
		return login_fail_cnt;
	}




	public void setLogin_fail_cnt(int login_fail_cnt) {
		this.login_fail_cnt = login_fail_cnt;
	}




	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
