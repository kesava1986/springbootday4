package com.keshav.springboot.springbootapp.service;

import java.util.List;

import com.keshav.springboot.springbootapp.beans.Student;

public interface StudentService {
	public void createStudent(Student student);
    public List<Student> getStudent();
    public Student findById(long id);
    public Student update(Student student);
    public void deleteStudentById(long id);
    public Student updatePartially(Student student, long id);

}
