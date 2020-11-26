package com.labbol.demo.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yelong.commons.lang.Strings;

import com.labbol.cocoon.controller.BaseCrudSupportController;
import com.labbol.cocoon.msg.JsonMsg;
import com.labbol.demo.student.dto.StudentDTO;
import com.labbol.demo.student.model.Student;

/**
 * 
 * @author YL
 *
 */
@Controller
@RequestMapping("student")
public class StudentController extends BaseCrudSupportController<StudentDTO> {

	public static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("index")
	public String index() {
		return "student/studentManage.jsp";
	}

	/**
	 * 修改学生年龄
	 * 
	 * @author PengFei
	 */
	@ResponseBody
	@RequestMapping("modifyStudentAge")
	public String modifyStudentAge() {
		String studentId = getParameter("studentId");
		Strings.requireNonBlank(studentId, "必填参数缺失：studentId");
		Student student = new Student();
		student.setAge(10);
		student.setId(studentId);
		modelService.modifySelectiveById(student);
		return toJson(new JsonMsg(true, "修改成功"));
	}

}
