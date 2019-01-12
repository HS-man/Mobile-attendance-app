package com.example.mobile_attendance_app;

public class courseData {
    String course_name,teacher,room,time,state;
    public courseData(String state,String teacher,String course_name,String room,String time) {
		// TODO Auto-generated constructor stub
    	this.course_name=course_name;
    	this.teacher=teacher;
    	this.room=room;
    	this.state=state;
    	this.time=time;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
