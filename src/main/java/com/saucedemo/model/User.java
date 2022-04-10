package com.saucedemo.model;

public enum User
{
    CHRIS("standard_user", "secret_sauce"),
    LORA("locked_out_user", "secret_sauce");

    private String username;
    private String password;

    User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUserName()
    {
        return username;
    }

    public String getUserPassword()
    {
        return password;
    }
}
