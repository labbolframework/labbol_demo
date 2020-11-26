package com.labbol.demo.user.model;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

@Table(value = "co_user", alias = "usr")
public class User extends BaseModel<User> {

	private static final long serialVersionUID = -8087431935836935350L;

	@Column(column = "username", maxLength = 128, allowNull = true, columnName = "用户名称")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

