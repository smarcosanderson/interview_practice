
package com.douglascapi.examschedule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private long id;
        private String departmentCode;
        private String code;
        private String section;
        private String instructor;
        private String date;
        private String time;
        private String room;

        public Course(){  
        }
        public Course(String dptCode, String code, String section, String instructor, String date, String time, String room){  
                this.departmentCode = dptCode;
                this.code = code;
                this.section = section;
                this.instructor = instructor;
                this.date = date;
                this.time = time;
                this.room = room;
        }

        public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String code) {
		this.departmentCode = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
        }
        public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
        }
        public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

}
