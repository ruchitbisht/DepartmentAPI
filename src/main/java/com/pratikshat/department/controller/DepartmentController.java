package com.pratikshat.department.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pratikshat.department.entity.Department;
import com.pratikshat.department.service.DepartmentService;


@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger log=LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {

		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartment() {
		log.info("Inside a getDepartment...!!! ");
		return departmentService.getDepartment();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside a getDepartmentById...!!!");
		return departmentService.getDepartmentById(departmentId);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside a deleteDepartmentById....!!!");
		departmentService.deleteDepartmentById(departmentId);
		return "Successfully Deleted";
	}
	
	@PutMapping("/departments/{id}")
	public Department upadateDepartmentById(@RequestBody Department department , @PathVariable("id") Long departmentId) {		
		log.info("inside a upadateDepartmentById...!!!");
		return departmentService.upadateDepartmentById(department,departmentId);
	}
	
	@GetMapping("/department/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		log.info("Inside a getDepartmentByName..!!!");
		return departmentService.getDepartmentByName(departmentName);
	}
	

}



















