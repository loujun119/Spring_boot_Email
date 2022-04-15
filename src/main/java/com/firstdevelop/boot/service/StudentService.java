package com.firstdevelop.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.*;
import com.firstdevelop.boot.mapper.StudentMapper;
@Service
public class StudentService {
	@Autowired
	private StudentMapper studentmapper;
    
	public List<Student> searchALL(){
		return studentmapper.searchAll();
	}
	public List<Student> information() {
		return studentmapper.information();
	}
}