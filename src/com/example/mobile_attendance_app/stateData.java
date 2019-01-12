package com.example.mobile_attendance_app;

public class stateData {
	String course_student,student_state;
	public stateData(String course_student,String student_state) {
		// TODO Auto-generated constructor stub
		this.course_student=course_student;
		this.student_state=student_state;
	}
	public String getCourse_student() {
		return course_student;
	}
	public void setCourse_student(String course_student) {
		this.course_student = course_student;
	}
	public String getStudent_state() {
		return student_state;
	}
	public void setStudent_state(String student_state) {
		this.student_state = student_state;
	}

}
