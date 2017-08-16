package com.analytics.dau.service;

import com.analytics.dau.entity.RetentionType;
import com.analytics.dau.entity.User;

import java.util.Date;
import java.util.List;

public interface UserManager {
    List<User> getDailyActiveUsers(List<Date> dateList);

    List<User> getRetention(RetentionType type, Date date);
}
