package com.example.diabetesmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    public static final String NUMBER = "NUMBER";
    public static final String NAME = "NAME";


//    public static final String ID = "ID";
    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public SharedPreferences.Editor editor;
    public Context context;
    SharedPreferences sharedPreferences;
    int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }


    public void createSession( String name,String number) {
        editor.putBoolean(LOGIN, true);
        editor.putString(NUMBER, number);
        editor.putString(NAME, name);

        editor.apply();

    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Intent i = new Intent(context, nurselogin.class);
            context.startActivity(i);
            ((NurseHome) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(NUMBER, sharedPreferences.getString(NUMBER, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
//        user.put(ID, sharedPreferences.getString(ID, null));
        return user;
    }

    public void logout() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, nurselogin.class);
        context.startActivity(i);


    }
}
