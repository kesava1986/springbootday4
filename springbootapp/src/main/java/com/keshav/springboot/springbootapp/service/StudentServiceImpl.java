package com.keshav.springboot.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keshav.springboot.springbootapp.beans.Student;
import com.keshav.springboot.springbootapp.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return (List<Student>)studentRepository.findAll();
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		Optional<Student> optional =studentRepository.findById(id);
		return optional.get();
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student updatePartially(Student student, long id) {
		// TODO Auto-generated method stub
		Student st = findById(id);
	        st.setStudentName(student.getStudentName());
	        return studentRepository.save(st);

	}
	
	


}
