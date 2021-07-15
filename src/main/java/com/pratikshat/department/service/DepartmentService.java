package com.pratikshat.department.service;

import java.util.List;

import com.pratikshat.department.entity.Department;

public interface DepartmentService  {

	public Department saveDepartment(Department department);

	public List<Department> getDepartment();

	public Department getDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department upadateDepartmentById(Department department, Long departmentId);

	public Department getDepartmentByName(String departmentName);

}
