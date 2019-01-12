package com.example.mobile_attendance_app;

public class teacher_courseData {
	String course_name;
	String course_room;
	String course_time;
	String course_id;
	public teacher_courseData(String course_name,String course_room,String course_time,String course_id) {
		// TODO Auto-generated constructor stub
		this.course_name=course_name;
		this.course_room=course_room;
		this.course_time=course_time;
		this.course_id=course_id;
	}
	public String getCourse_room() {
		return course_room;
	}
	public void setCourse_room(String course_room) {
		this.course_room = course_room;
	}
	public String getCourse_time() {
		return course_time;
	}
	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
}
