package com.xxm.salary.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxm.salary.pojo.Employee;
import com.xxm.salary.pojo.User;
import com.xxm.salary.service.EmployeeService;
import com.xxm.salary.service.UserService;

/**
 * 用户控制器
 * @author Administrator
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	//登录,验证身份跳转
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest req) {
		HttpSession session = req.getSession();
		return userService.checkUser(user.getUid(), user.getPassword(), session);
	}
	
	//添加新的用户信息
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	//删除用户
	@PostMapping("/delUser")
	public boolean delUser(@RequestBody String uid) {
		return userService.delUser(uid);
	
	}
	
	//退出
	@GetMapping("/back")
	public String back(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("UID");
		return "login";
	}

	//修改密码
	@PostMapping("/changpwd")
	@ResponseBody
	public String changepwd(@RequestBody HashMap<String, String>map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		return userService.checkpwd(map,EmployeeID);
	}
	
}
