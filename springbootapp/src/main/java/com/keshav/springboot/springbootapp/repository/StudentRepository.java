package com.keshav.springboot.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.keshav.springboot.springbootapp.beans.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
