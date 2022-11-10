package com.sumon.mvploginvalidation.Presenter;

import android.os.Looper;
import android.os.Handler;

import com.sumon.mvploginvalidation.Model.IUser;
import com.sumon.mvploginvalidation.Model.UserImpl;
import com.sumon.mvploginvalidation.View.ILoginView;



public class LoginPresenterImpl implements ILoginPresenter{


    private ILoginView iLoginView;
    private Handler handler;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void doLogin(String email, String pass) {

        IUser user = new UserImpl(email, pass);
        int login_code = user.checkUserValidity();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (login_code==0)
                {
                    iLoginView.onLoginError("Please Enter Your Email");
                }

                else if (login_code==1)
                {
                    iLoginView.onLoginError("please Enter a Valid Email");
                }

                else if (login_code==2)
                {
                    iLoginView.onLoginError("Please Enter Your Password");
                }

                else if (login_code==3)
                {
                    iLoginView.onLoginError("Please Enter a Password that should be more than 6 character");
                }

                else
                {
                    iLoginView.onLoginError("Login Successful");
                }


            }
        },2000);




    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }
}
