package com.sumon.mvploginvalidation.Model;

public interface IUser {

    String getEmail();
    String getPassword();
    int checkUserValidity();
}
