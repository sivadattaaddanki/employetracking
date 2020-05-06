package com.myproject.go.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myproject.go.entityfwk.RegestrationEntity;
import com.myproject.go.entityfwk.UserAttendance;
import com.myproject.go.model.UserAttendanceSchema;
import com.myproject.go.serv.RegServiceImp;

@Repository
public class RegestrationDaoImp {
@PersistenceContext
private EntityManager entitymanager;
public static final Logger LOGGER=LoggerFactory.getLogger(RegestrationDaoImp.class);
@SuppressWarnings("unchecked")
public String checkEmail(String s) {
	LOGGER.info("daorepo");
	String  queryString = "select c from RegestrationEntity c where c.emailId = ?1";
	Query query = entitymanager.createQuery(queryString);
	query.setParameter(1, s);
	LOGGER.info("daorepo");
	List<RegestrationEntity> l = new ArrayList<RegestrationEntity>();
	l=query.getResultList();
	if(l.size()>0) {
		return "Email Already Regestered.Please try with another Email";
	}
	else return null;
}
@SuppressWarnings("unchecked")
public String markInTimeAttendance(LocalTime inTimeOfDay,String emailId) {
	
	LOGGER.info("daorepo");
	String  queryString = "select c from RegestrationEntity c where c.emailId = ?1";
	Query query = entitymanager.createQuery(queryString);
	query.setParameter(1, emailId);
	
	List<RegestrationEntity> r = new ArrayList<RegestrationEntity>();
	r=query.getResultList();
	RegestrationEntity fin = new RegestrationEntity();
	LOGGER.info("size:{}",r.size());
	try {
		if(r.size()==0) {
			throw new Exception("Please Regester yourself,talk to your manager for attendance");
		}
		else {
			fin=r.get(0);
			int id=getuserIdByEmailId(emailId);
			LOGGER.info("in outtime dao id:{}",id);
			String  queryString1 = "select k from UserAttendance k where k.userId=?1 AND k.presentDay=?2" ;
			Query query1 = entitymanager.createQuery(queryString1);
			query1.setParameter(1, id);
			query1.setParameter(2, LocalDate.now());
			List<UserAttendance> re = new ArrayList<UserAttendance>();
//			UserAttendance ua =new UserAttendance();
			re=query1.getResultList();
			
			if(re.size()!=0 && re.get(0).getInTimeOfDay()!=null) {
				throw new Exception("you had already marked inTIme for today");
			}
			else {
				UserAttendance u = new UserAttendance();
				LocalDate today = LocalDate.now();
				u.setPresentDay(today);
				u.setInTimeOfDay(inTimeOfDay);
				List<UserAttendance> ue = fin.getAttendance();
				ue.add(u);
				fin.setAttendance(ue);
				return "In time is regestered";
			}
			}
	}
	catch(Exception e) {
		return e.getMessage();
	}
	
	
}

@SuppressWarnings("unchecked")
public int getuserIdByEmailId(String emailId) {
	String  queryString1 = "select d from RegestrationEntity d where d.emailId = ?1" ;
	Query query1 = entitymanager.createQuery(queryString1);
	query1.setParameter(1, emailId);
	List<RegestrationEntity> re = new ArrayList<RegestrationEntity>();
	RegestrationEntity fin = new RegestrationEntity();
	re=query1.getResultList();
	fin=re.get(0);
	return fin.getUserId();
}

@SuppressWarnings("unchecked")
public String markOutTimeAttendance(LocalTime outTimeOfDay,String emailId) {
	LOGGER.info("in outtime dao");
	int id=getuserIdByEmailId(emailId);
	LOGGER.info("in outtime dao id:{}",id);
	String  queryString1 = "select k from UserAttendance k where k.userId=?1 AND k.presentDay=?2" ;
	Query query1 = entitymanager.createQuery(queryString1);
	query1.setParameter(1, id);
	query1.setParameter(2, LocalDate.now());
	List<UserAttendance> re = new ArrayList<UserAttendance>();
	UserAttendance ua =new UserAttendance();
	re=query1.getResultList();
	LOGGER.info("in outtime sizie :{}",re.size());
	try {
		if(re.size()==0) {
			throw new Exception("Mark your inTime first");
		}
		if(ua.getOutTimeOfDay()!=null) {
			throw new Exception("Your already regestered your out time");
			
		}
		ua=re.get(0);
		ua.setOutTimeOfDay(outTimeOfDay);
		return "Outtime is regestered successfully";
	}
	catch(Exception e) {
		return e.getMessage();
	}

}
}
