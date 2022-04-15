package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.firstdevelop.boot.entity.*;

@Mapper

public interface StudentMapper {
 List<Student> searchAll(); 
 List<Student> information();
}