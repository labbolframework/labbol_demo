package test.model;

import java.util.Date;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.PrimaryKey;
import org.yelong.core.model.annotation.Table;

@Table(value = "co_user", alias = "usr")
public class User implements Modelable {

	private static final long serialVersionUID = -8087431935836935350L;

	@PrimaryKey // 标明该字段为主键
	@Column(column = "id", maxLength = 32, allowNull = false, columnName = "主键")
	private String id;

	@Column(column = "username", maxLength = 128, allowNull = true, columnName = "用户名称")
	private String username;

	@Column(column = "creator", maxLength = 32, allowNull = false, columnName = "创建人")
	private String creator;

	@Column(column = "createTime", allowNull = false, columnName = "创建时间")
	private Date createTime;

	@Column(column = "updator", maxLength = 32, allowNull = false, columnName = "更新人")
	private String updator;

	@Column(column = "updateTime", allowNull = false, columnName = "更新时间")
	private Date updateTime;

	@Column(column = "state", maxLength = 1, allowNull = false, columnName = "状态")
	private String state;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
