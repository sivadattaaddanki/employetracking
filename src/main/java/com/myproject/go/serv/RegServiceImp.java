package com.myproject.go.serv;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.go.entityfwk.AddressEntity;
import com.myproject.go.entityfwk.RegestrationEntity;
import com.myproject.go.model.LoginSchema;
import com.myproject.go.model.RegestrationSchema;
import com.myproject.go.model.UserAttendanceSchema;
import com.myproject.go.repo.RegestrationDaoImp;
import com.myproject.go.repo.RegestrationRepo;
import com.myproject.go.validators.validators;
@Service
@Transactional
public class RegServiceImp implements RegService {
	@PersistenceContext
	private EntityManager entitymanager;
	@Autowired
	private RegestrationRepo regestration;
	@Autowired
	private validators validate;
	@Autowired
	private RegestrationDaoImp regestrationDaoImp;
	public static final Logger LOGGER=LoggerFactory.getLogger(RegServiceImp.class);
		@Override
		public String addUser(RegestrationSchema r) {
			// TODO Auto-generated method stub
			
			LOGGER.info("details of r:{}",r.getEmailId());  
			try {
				LOGGER.info("details of r:{}",r.getEmailId());
				if(validate.emailValidator(r.getEmailId())==null) {
					RegestrationEntity rnew = new RegestrationEntity();
					AddressEntity anew = new AddressEntity();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String date = r.getDob();
					//convert String to LocalDate
					LocalDate localDate = LocalDate.parse(date, formatter);
					rnew.setDob(localDate);
					rnew.setEmailId(r.getEmailId());
					rnew.setUserName(r.getUserName());
					rnew.setPassword(r.getPassword());
					rnew.setPhoneNumber(r.getPhoneNumber());
					rnew.setAadharNumber(r.getAadharNumber());
					rnew.setPanNumber(r.getPanNumber());
					LOGGER.info("details of district:{}",r.getDistrict());
					LOGGER.info("details of district:{}",r.getSecondLine());
					anew.setDistrict(r.getDistrict());
					anew.setFirstLine(r.getFirstLine());
					anew.setSecondLine(r.getSecondLine());
					anew.setState(r.getState());
					anew.setPincode(r.getPincode());
					rnew.setAddress(anew);
					regestration.save(rnew);
					LOGGER.info("details of rnew:{}",rnew.getAadharNumber());
					LOGGER.info("details of rnew:{}",rnew.getAddress());
					return regestration.getOne(rnew.getUserId()).getUserName();
				}
				else return validate.emailValidator(r.getEmailId());
			}
			catch (Exception e){
				LOGGER.info("exception catched at adduserservice");
				LOGGER.info("exception catched is:{}",e.getMessage());
				return e.getMessage();
			}
			finally {
				LOGGER.info("exiting service file");
			}
		}
		@Override
		public String Logintest(LoginSchema l) {
			// TODO Auto-generated method stub
			LOGGER.info("details of luser:{}",l.getUserName());
			LOGGER.info("details of lpass:{}",l.getPassword());
			
			String queryString="select c from RegestrationEntity c where c.emailId = ?1";
			Query query = entitymanager.createQuery(queryString);
			query.setParameter(1, l.getUserName());
			@SuppressWarnings("unchecked")
			List<RegestrationEntity> result=query.getResultList();
			RegestrationEntity temp = result.get(0);
			if(temp.getPassword().equals(l.getPassword())) {
				return "LOGIN SUCCESS";
			}
			else {
				return "Incorrect Passwword or username";
			}
		}
		@Override
		public String markInTimeAttendance(String inTimeOfDay,String emailId) {
			// TODO Auto-generated method stub
			try {
				LocalTime inTime = LocalTime.parse(inTimeOfDay);
				return regestrationDaoImp.markInTimeAttendance(inTime,emailId);
			}
			catch(Exception e) {
				return e.getMessage();
			}
//			sdadsad
		}
		@Override
		public String markOuTimeAttendance(String outTimeOfDay, String emailId) {
			// TODO Auto-generated method stub
			try {
				LOGGER.info("in outtime service");
				LocalTime outTime = LocalTime.parse(outTimeOfDay);
				return regestrationDaoImp.markOutTimeAttendance(outTime,emailId);
			}
			catch(Exception e) {
				return e.getMessage();
			}
		}

}
