package com.model;

public class Student {

	private int studentNo;
	private String studentName;
	private int marks;
	public Student() {
		super();
		
	}
	public Student(int studentNo, String studentName, int marks) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.marks = marks;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
}
