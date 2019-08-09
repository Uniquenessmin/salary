package com.xxm.salary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xxm.salary.pojo.Department;

@Mapper
public interface DepartmMapper {
	@Select("select * from department")
	List<Department> findDepartment();
	
	@Select("select dno from department where dname = #{DepartmentName} ")
	String findDepartmentID(@Param("DepartmentName") String DepartmentName);
	
	@Select("select dname from department where dno = #{DepartmentID}")
	String getDepartmentName(@Param("DepartmentID")String DepartmentID);

}
