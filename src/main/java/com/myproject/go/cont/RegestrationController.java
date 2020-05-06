package com.myproject.go.cont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.go.entityfwk.RegestrationEntity;
import com.myproject.go.model.LoginSchema;
import com.myproject.go.model.RegestrationSchema;
import com.myproject.go.serv.RegServiceImp;

@RestController
@RequestMapping("/please")
public class RegestrationController {
	@Autowired
	private RegServiceImp Service;
	

	@PostMapping("/add")
	public String addUser(@RequestBody RegestrationSchema reges) {
		return Service.addUser(reges);

	}
	@GetMapping("/get")
	public String Logintest(@RequestBody LoginSchema l) {
		
		return Service.Logintest(l);
	}
	@PostMapping("/addatt/{inTime}/{emailId}")
	public String markInTimeAttendance(@PathVariable String inTime,@PathVariable String emailId) {
		return Service.markInTimeAttendance(inTime,emailId);
	}
	@PostMapping("/addatta/{outTime}/{emailId}")
	public String markOutTimeAttendance(@PathVariable String outTime,@PathVariable String emailId) {
		return Service.markOuTimeAttendance(outTime,emailId);
	}
	 

}
