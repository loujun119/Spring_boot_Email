/*
 * 
 */
package com.firstdevelop.boot.entity;

import java.time.LocalDateTime;

/**
 * @author study
 *
 */
public class Student {
	
	// 変数定義id
	private int id;
	// 変数定義氏名
	private String name;
	// 変数定義生年月日
	private LocalDateTime birthday;
	// 変数定義年齢
	private int age;
	// 変数定義成績
	private double score;
	// 変数定義授業id
	private int classid;
	// 変数定義住所
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the birthday
	 */
	public LocalDateTime getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	/**
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param classid
	 * @param address
	 */
	public Student(int id, String name, LocalDateTime birthday, int age, double score, int classid, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
		this.classid = classid;
		this.address = address;
	}
	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	
	 

}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score
				+ ", classid=" + classid + ", address=" + address + "]";
	}
}
