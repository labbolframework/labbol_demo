package com.labbol.demo.student.dto;

import org.yelong.core.model.annotation.ExtendTable;
import org.yelong.core.model.annotation.Select;

import com.labbol.demo.student.model.Student;

@Select("select \r\n" + 
		"student.* ,\r\n" + 
		"school.name schoolName\r\n" + 
		"from tb_sm_student_info student\r\n" + 
		"left join tb_sm_school_info school on school.id = student.schoolId")
@ExtendTable
public class StudentDTO extends Student {

	private static final long serialVersionUID = -1077280443523622032L;

	private String schoolName;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}

