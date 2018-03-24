package com.kakaxi.androidmvp.model.user;

import java.io.Serializable;


public class UserInfo implements Serializable {
	private String user_id;
	private String name;
	private String headimg;
	private String tel;
	private String push;
	private String pushToken;

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	public String getPush() {
		return push;
	}

	public void setPush(String push) {
		this.push = push;
	}

	private String department_id;
	private String display_instructions_view;

	public String getDisplay_instructions_view() {
		return display_instructions_view;
	}

	public void setDisplay_instructions_view(String display_instructions_view) {
		this.display_instructions_view = display_instructions_view;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	private String department;
	private String position;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
