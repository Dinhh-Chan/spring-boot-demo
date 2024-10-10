package com.example.demo.dto.request;

public class UserUpdateRequest {
    private String password;
    private String firstname;
    private String lastname;
    public String getFirsname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getPassword(){
        return password; 
    }
    public void setPassword(String password){
        this.password = password ;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname ;
    }
}
