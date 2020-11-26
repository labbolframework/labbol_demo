package com.labbol.demo.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yelong.core.model.manage.FieldAndColumn;
import org.yelong.core.model.manage.ModelAndTable;
import org.yelong.core.model.sql.SqlModelResolver;

import com.labbol.core.controller.BaseCoreController;
import com.labbol.core.service.LabbolModelService;
import com.labbol.demo.user.model.User;

@Controller
@RequestMapping("user")
public class UserController extends BaseCoreController {

	@Resource
	private LabbolModelService modelService;

	/**
	 * 
	 * @see SqlModelResolver#resolveToConditions(org.yelong.core.model.sql.SqlModel, boolean)
	 * @author PengFei
	 * @date 2020年11月26日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("test")
	public String test() {
		ModelAndTable modelAndTable = modelService.getModelConfiguration().getModelAndTable(User.class);
		// 获取模型中唯一的主键列，如果不存在主键列或者存在多个主键列均会抛出异常
		FieldAndColumn primaryKey = modelAndTable.getOnlyPrimaryKey();
		// 打印主键的字段名称和列名称
		System.out.println(primaryKey.getFieldName() + ":" + primaryKey.getColumn());
		return "";
	}

}
