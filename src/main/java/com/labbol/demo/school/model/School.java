package com.labbol.demo.school.model;

import java.util.Date;

import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.Table;

import com.labbol.core.model.BaseModel;

/**
 * tb_sm_school_info 学校管理
 *
 * @author YL
 */
@Table(value="tb_sm_school_info",alias="school",desc="学校管理")
public class School extends BaseModel<School> {
	
	private static final long serialVersionUID = 1513162544765730591L;

	@Column(column = "name",maxLength = 128,columnName = "名称")
	private String name;
	
	@Column(column = "schoolMaster",maxLength = 128,columnName = "校长")
	private String schoolMaster;
	
	@Column(column = "startDate",columnName = "创办日期")
	private Date startDate;

	/**
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return 校长
	 */
	public String getSchoolMaster() {
		return schoolMaster;
	}

	/**
	 * @param schoolMaster 校长
	 */
	public void setSchoolMaster(String schoolMaster) {
		this.schoolMaster = schoolMaster;
	}
	
	/**
	 * @return 创办日期
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate 创办日期
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
