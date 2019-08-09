package com.xxm.salary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxm.salary.mapper.DepartmMapper;
import com.xxm.salary.mapper.WageconfigMapper;
import com.xxm.salary.pojo.Department;
import com.xxm.salary.pojo.WageConfig;

@Service
public class WageconfigService {

	@Autowired
	WageconfigMapper wmapper;
	@Autowired
	DepartmMapper departmentMapper;
	
	@Autowired
	DepartmentService departmentService;
	
	//添加新的职位薪资信息
	public boolean addDuty(WageConfig wc) {
		return wmapper.addPosition(wc);
	}

	//部门的职位
	public List<WageConfig> getDutyList(String departmentName) {
		String departmentID = departmentService.getDepartmentID(departmentName);
		System.out.println( departmentID);
		
		List<WageConfig> list = wmapper.getWid(departmentID);
		for (WageConfig wageConfig : list) {
			wageConfig.setDno(departmentMapper.getDepartmentName(wageConfig.getDno()));
			System.out.println(wageConfig.getPosition());
			System.out.println(wageConfig.getDno());
		}
		return list;
	}

	public List<String> getDutyList() {
		List<String> positionNames = new ArrayList<String>();
		List<WageConfig> wigeList = wmapper.getWids2();
		for (WageConfig w : wigeList) {
			positionNames.add(w.getWid());
		}
		return positionNames;
	
	}
	
	public String getId(String p) {
		return wmapper.getId(p);
	}
	
	
}
