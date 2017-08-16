package com.analytics.dau.controller;

import com.analytics.dau.entity.RetentionType;
import com.analytics.dau.service.UserManager;
import com.analytics.dau.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.analytics.dau.Util.getDate;

public class DailyActiveUsersAction extends ActionSupport {
    private static final long serialVersionUID = 1L;


    private List<User> daus;
    private List<String> dates;
    private Date dateOfUser;
    private List<User> retention;
    private int type;
    private Date retentionDate;

    //User manager injected by spring context; This is cool !!
    private UserManager userManager;

    //This method return list of users in database
    public String listUsers() throws ParseException {

	return SUCCESS;
    }


    //This method will be called when a date object is added
    public String dau() throws ParseException {
        List<Date> dateOfList = new ArrayList<>();
        Date d;
        if (dates == null) {
            addFieldError("dateOfUser", "You should add a Date.");
            return INPUT;
        }
        for (String date: dates) {
            d = getDate(date);
            dateOfList.add(d);
        }
        daus = userManager.getDailyActiveUsers(dateOfList);
        return SUCCESS;
    }

    public String retention() throws ParseException {
        boolean valid = true;
        if (type == -1) {
            addFieldError("type", "Retention type is required.");
            valid = false;
        }
        if (getRetentionDate() == null) {
            addFieldError("retentionDate", "Retention date is required.");
            valid = false;
        }
        if (!valid){
            return INPUT;
        }

        retention = userManager.getRetention(RetentionType.getType(type), retentionDate);
        return SUCCESS;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public Date getDateOfUser() {
        return dateOfUser;
    }

    public void setDateOfUser(Date dateOfUser) {
        this.dateOfUser = dateOfUser;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public List<User> getDaus() {
        return daus;
    }

    public List<User> getRetention() {
        return retention;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getRetentionDate() {
        return retentionDate;
    }

    public void setRetentionDate(Date retentionDate) {
        this.retentionDate = retentionDate;
    }
}
