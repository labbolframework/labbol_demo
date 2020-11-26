package com.labbol.demo.student.model;

import java.util.Date;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

/**
 * tb_sm_student_info 学生管理
 *
 * @author YL
 */

@Table(value = "tb_sm_student_info", alias = "student", desc = "学生管理")
public class Student extends BaseModel<Student> {

	private static final long serialVersionUID = 5278479576784766335L;

	@Column(column = "schoolId", maxLength = 32, columnName = "学校ID")
	private String schoolId;

	@Column(column = "name", maxLength = 128, columnName = "姓名")
	private String name;

	@Column(column = "age", columnName = "年龄")
	private Integer age;

	@Column(column = "birthdate", columnName = "出生年月")
	private Date birthdate;

	/**
	 * @return 学校ID
	 */
	public String getSchoolId() {
		return schoolId;
	}

	/**
	 * @param schoolId 学校ID
	 */
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 年龄
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age 年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return 出生年月
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate 出生年月
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
