package com.xxm.salary.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxm.salary.service.DepartmentService;


@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * 得到部门列表
	 * @return
	 */
	@GetMapping("/department")
	public List<String> findDepartmentName() {
		System.out.println(departmentService.findDepartmentName());
		return departmentService.findDepartmentName();
	}
	
}
