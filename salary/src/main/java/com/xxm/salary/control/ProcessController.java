package com.xxm.salary.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.xxm.salary.pojo.Employee;
import com.xxm.salary.service.EmployeeService;

@Controller
public class ProcessController {

	@Autowired
	EmployeeService employeeService;
	
	//用户修改个人信息
	@PostMapping("/userset")
	public String UserSet(Employee employee,HttpServletRequest req) {
		HttpSession session = req.getSession();
		System.out.println(employee.getPhone()+"#####"+employee.getEmail()+"#####"+employee.getEid());
		if(employeeService.setEmploy(employee.getEmail(), employee.getPhone(), employee.getEid(),session)) {
			
			String picture="";
			picture = employee.getPicture() ;
			
			System.out.println(picture);
			employeeService.setPic(picture,employee.getEid(),session);
			return "employeeinfo";
		}else return "employeeinfo";
	}
}
