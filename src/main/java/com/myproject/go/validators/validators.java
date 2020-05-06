package com.myproject.go.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.go.repo.RegestrationDaoImp;
import com.myproject.go.serv.RegServiceImp;
@Component
public class validators {
	public static final Logger LOGGER=LoggerFactory.getLogger(validators.class);
	@Autowired
	private RegestrationDaoImp repo;
	public String emailValidator(String s) {
		String result=null;
		LOGGER.info("invalidators");
		result=repo.checkEmail(s);
		LOGGER.info("invalidators:{}",result);
		if(result!=null) {
			return result;
		}
		return null;
	}
}
