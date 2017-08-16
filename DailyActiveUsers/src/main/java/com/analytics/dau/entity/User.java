package com.analytics.dau.entity;

import java.util.Date;


public class User {

    private String id;
    private Date requestDate;

    public User(String id, Date requestDate) {
        this.id = id;
        this.requestDate = requestDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return requestDate != null ? requestDate.equals(user.requestDate) : user.requestDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}