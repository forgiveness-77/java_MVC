package com.pharmacy.models;

public class User {
    private int user_id;
    private String name;
    private String username;
    private String email;
    private String password;

    public User(int id, String n, String un, String em, String pass){
        this.user_id= Integer.parseInt(n);
        this.name=n;
        this.username=un;
        this.email=em;
        this.password=pass;
    }
    public User(String n, String un, String em, String pass){
        this.name=n;
        this.username=un;
        this.email=em;
        this.password=pass;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String toString(){
        return "User: {Id:"+ user_id +" }, {Name: "+name+" }, {Username:"+ username +" }, {Email: "+email+" }";
    }
}
