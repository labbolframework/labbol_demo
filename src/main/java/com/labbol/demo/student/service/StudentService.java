package com.labbol.demo.student.service;

public interface StudentService {

	/**
	 * 修改年龄
	 * 
	 * @author PengFei
	 * @date 2020年11月26日
	 * @param id  学生主键
	 * @param age 年龄
	 * @return 修改的记录数
	 * @throws UnsupportedOperationException 不支持操作的异常
	 */
	Integer modifyAge(String id, Integer age) throws UnsupportedOperationException;

}
