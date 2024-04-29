package com.spring.orm1.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.spring.orm1.entities.Student;

import java.util.List;

import javax.transaction.Transactional;



public class StudentDao {

	
	
	private HibernateTemplate hibernateTemplate;
	
	
	//save student also called as create Statement
	@Transactional
	public int insert(Student student)
	{
		//insert
		int i=(int)this.hibernateTemplate.save(student);
		return i;
	}
	
	
	//get the single data(object)
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	
	//get all students(all rows)
	public List<Student>getAllStudents()
	{
		List<Student>students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	
	//deleting the data
	//we don't need @Transactional in read operation
	//but in write operation we need @Transactional and deleting data is a write operation
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	
	//updating the data
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public StudentDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}


	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
