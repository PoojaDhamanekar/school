package com.project.School.Service;

import java.util.List;

import com.project.School.Entity.student;

public interface ServiceInterface {

	List<student> getAllStudent();

	student addStudent(student stud);

	void deletestudent(Long idL);

	student updateStudent(Long id, student updatedStudent);

}
