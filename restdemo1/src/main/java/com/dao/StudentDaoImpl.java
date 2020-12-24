package com.dao;

import org.springframework.stereotype.Repository;


import com.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {

	

	@Override
	public Student getStudentdao(int studId) {
		Student student=null;
		if(studId==100)
		{
			student=new Student(100,"Hundred",99);
		}
		
			if(studId==20)
			{
				student=new Student(200," 2 Hundred",299);
			}
		return student;
	}
	

}
