package com.labbol.demo.student.service.impl;

import javax.annotation.Resource;

import com.labbol.core.service.LabbolModelService;
import com.labbol.demo.student.service.StudentService;

/**
 * 默认学生业务实现
 * 
 * @author PengFei
 */
public class StudentServiceImpl implements StudentService {

	@Resource
	private LabbolModelService modelService;

	@Override
	public Integer modifyAge(String id, Integer age) throws UnsupportedOperationException {
		return null;
	}

}
