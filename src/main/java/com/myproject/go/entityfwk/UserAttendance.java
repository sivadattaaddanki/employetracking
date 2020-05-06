package com.myproject.go.entityfwk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userAttendance")
public class UserAttendance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer attendanceId;
	private LocalDate presentDay;
	private LocalTime inTimeOfDay;
	private LocalTime OutTimeOfDay;
	@Column(name="user_id")
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Integer getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
	public LocalDate getPresentDay() {
		return presentDay;
	}
	public void setPresentDay(LocalDate presentDay) {
		this.presentDay = presentDay;
	}
	public LocalTime getInTimeOfDay() {
		return inTimeOfDay;
	}
	public void setInTimeOfDay(LocalTime inTimeOfDay) {
		this.inTimeOfDay = inTimeOfDay;
	}
	public LocalTime getOutTimeOfDay() {
		return OutTimeOfDay;
	}
	public void setOutTimeOfDay(LocalTime outTimeOfDay) {
		OutTimeOfDay = outTimeOfDay;
	}
	

}
