package com.analytics.dau.entity;

/**
 * Created by avetisyan on 8/13/2017.
 */
public enum RetentionType {
    Day1(1),
    Day7(7),
    Day40(40);

    private int days;

    RetentionType(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
    public static RetentionType getType(int days){
        if (days == 1) {
            return RetentionType.Day1;
        } else if (days == 7) {
            return RetentionType.Day7;
        } else {
            return RetentionType.Day40;
        }
    }
}
