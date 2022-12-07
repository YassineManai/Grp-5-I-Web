package com.example.ProjectMobile.Model;

public class Data {

    String Domain;
    String level;
    String Location;
    String Duration;
    String Contact;


    String id;
    String date;


    public Data() {

    }

    public Data(String Domain, String level, String Location, String Duration, String Contact,String id, String date) {
        this.Domain = Domain;
        this.level = level;
        this.Location = Location;
        this.Duration = Duration;
        this.Contact = Contact;
        this.id = id;
        this.date = date;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
