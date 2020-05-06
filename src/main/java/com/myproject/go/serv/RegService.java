package com.myproject.go.serv;

import java.time.LocalTime;

import com.myproject.go.model.LoginSchema;
import com.myproject.go.model.RegestrationSchema;
import com.myproject.go.model.UserAttendanceSchema;

public interface RegService {
	public String addUser(RegestrationSchema r);
	public String Logintest(LoginSchema l);
	public String markInTimeAttendance(String inTimeOfDay,String emailId);
	public String markOuTimeAttendance(String outTimeOfDay,String emailId);
}
