package com.example.modelviewviewmodel;

import android.app.Notification;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AppViewModel extends BaseObservable {

    private Model model;

    private String successMessage = "Login succesful";
    private String errorMessage = "Email or Password is not valid";

    public AppViewModel(){
        model = new Model("","");
    }

    public void onButtonClicked(){
        if(isValid()){
            setToastMessage(successMessage);
        }
        else{
            setToastMessage(errorMessage);
        }
    }

    public boolean isValid(){
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }


    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    @Bindable
    public String getUserEmail(){
        return model.getEmail();
    }

    public void setUserEmail(String email){
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }


    @Bindable
    public String getUserPassword(){
        return model.getPassword();
    }

    public void setUserPassword(String password){
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }




}
