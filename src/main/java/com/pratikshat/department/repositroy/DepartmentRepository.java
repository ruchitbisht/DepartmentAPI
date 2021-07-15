package com.pratikshat.department.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratikshat.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , Long> {

	public Department findByDepartmentName(String departmentName);


}
