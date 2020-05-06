package com.myproject.go.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserAttendanceSchema {
	
	private LocalDate presentDay;
	private LocalTime inTimeOfDay;
	private LocalTime OutTimeOfDay;
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
