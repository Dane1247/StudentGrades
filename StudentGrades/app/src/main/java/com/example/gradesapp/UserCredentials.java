package com.example.gradesapp;

public class UserCredentials {

    // Sean
    private String username;
    // Sean
    private String password;
    // Sean
    private String passConf;

    // Sean
    public UserCredentials(String username, String password, String passConf){
        this.username = username;
        this.password = password;
        this.passConf = passConf;
    }

    // Sean
    public String getUsername(){ return this.username; }
    // Sean
    public String getPassword(){ return this.password; }
    // Sean
    public String getPassConf(){ return this.passConf; }

    // Sean
    public boolean passwordMatches() {
        return this.getPassConf().equals(this.getPassword());
    }

    // Sean
    public boolean usernameTaken(){
        return false;
    }
}
