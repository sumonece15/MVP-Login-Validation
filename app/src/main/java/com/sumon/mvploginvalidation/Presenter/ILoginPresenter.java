package com.sumon.mvploginvalidation.Presenter;

public interface ILoginPresenter {

    void doLogin(String email, String pass);
    void setProgressBarVisibility(int visibility);
}
