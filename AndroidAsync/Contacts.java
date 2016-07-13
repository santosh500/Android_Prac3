package com.example.santo_000.jsonparsingdemo;

/**
 * Created by santo_000 on 6/26/2016.
 */
public class Contacts {

    private String first_name,last_name,email;

    public Contacts(String first_name,String last_name, String email)
    {
        this.setEmail(email);
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
