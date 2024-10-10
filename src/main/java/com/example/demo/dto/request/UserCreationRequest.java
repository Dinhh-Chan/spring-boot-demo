package com.example.demo.dto.request;

import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    
    private String username;
    @Size(min = 8, message="mat khau phai 8 ki tu dcm")
    private String password;

    private String firstname;
    private String lastname;
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username= username ;
    }
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
