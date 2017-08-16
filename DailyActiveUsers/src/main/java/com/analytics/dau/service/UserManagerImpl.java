package com.analytics.dau.service;

import com.analytics.dau.dao.UserDAO;
import com.analytics.dau.entity.RetentionType;
import com.analytics.dau.entity.User;

import java.util.Date;
import java.util.List;

public class UserManagerImpl implements UserManager {

	// User dao injected by Spring context
    private UserDAO userDAO;

	// This setter will be used by Spring context to inject the dao's instance
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getDailyActiveUsers(List<Date> dateList) {
		return userDAO.getDailyActiveUsers(dateList);
	}

	@Override
	public List<User> getRetention(RetentionType type, Date date) {
		return userDAO.getRetention(type, date);
	}
}
