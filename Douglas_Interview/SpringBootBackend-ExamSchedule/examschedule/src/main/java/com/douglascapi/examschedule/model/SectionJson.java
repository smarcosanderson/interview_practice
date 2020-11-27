package com.douglascapi.examschedule.model;

public class SectionJson {
	private String Number;
	private String Instructor;
	private String Date;
	private String Time;
	private String Room;
    
	public SectionJson() {
		super();
	}
	public SectionJson(String number, String instructor, String date, String time, String room) {
		super();
		Number = number;
		Instructor = instructor;
		Date = date;
		Time = time;
		Room = room;
	}
	
	
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getRoom() {
		return Room;
	}
	public void setRoom(String room) {
		Room = room;
	}
    
    
}
