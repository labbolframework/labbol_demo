package com.labbol.demo.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labbol.cocoon.controller.BaseCrudSupportController;
import com.labbol.demo.school.model.School;

@Controller
@RequestMapping("school")
public class SchoolController extends BaseCrudSupportController<School> {

	@RequestMapping("index")
	public String index() {
		return "school/schoolManage.jsp";
	}
	
}
