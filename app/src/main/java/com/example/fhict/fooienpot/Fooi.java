package com.example.fhict.fooienpot;

/**
 * Created by fhict on 30/11/2017.
 */

public class Fooi {
    private String amount;
    private String department;
    private String comment;


    public Fooi(String amount, String department, String comment) {
        this.amount = amount;
        this.department = department;
        this.comment = comment;
    }

    public void setAmount(String a) {
        this.amount = a;
    }

    public void setDepartment(String d) {
        this.department = d;
    }

    public void setComment(String c) {
        this.comment = c;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getComment() {
        return this.comment;
    }
}
