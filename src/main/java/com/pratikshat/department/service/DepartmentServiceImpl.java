package com.pratikshat.department.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratikshat.department.entity.Department;
import com.pratikshat.department.repositroy.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentrepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentrepository.save(department);
	}

	@Override
	public List<Department> getDepartment() { 
		return departmentrepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long departmentId)  {
		
		Optional<Department> dept= departmentrepository.findById(departmentId);
		return dept.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentrepository.deleteById(departmentId);
	}

	@Override
	public Department upadateDepartmentById(Department department, Long departmentId) {
		
		Department db= departmentrepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())) {
			db.setDepartmentName(department.getDepartmentName());
		}
		if(department.getDepartmentAddress()!=null && !department.getDepartmentAddress().equalsIgnoreCase("")) {
			db.setDepartmentAddress(department.getDepartmentAddress());
		}		
		if(department.getDepartmentCode()!=null && !"".equals(department.getDepartmentCode())) {
			db.setDepartmentCode(department.getDepartmentCode());
		}
		System.out.println(db);
		return departmentrepository.save(db);
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentrepository.findByDepartmentName(departmentName);
	}

}




















