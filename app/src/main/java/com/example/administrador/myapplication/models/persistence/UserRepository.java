package com.example.administrador.myapplication.models.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.myapplication.util.AppUtil;

public class UserRepository {

    private static class Singleton {
        public static final UserRepository INSTANCE = new UserRepository();
    }

    private UserRepository() {
        super();
    }

    public static UserRepository getInstance() {
        return Singleton.INSTANCE;
    }

    public Boolean authenticate(String user, String password) {
        DatabaseHelper helper = new DatabaseHelper(AppUtil.CONTEXT);
        String where = UserContract.USER + " = ? AND " + UserContract.PASSWORD + " = ?";
        String[] args = {user, password};
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(UserContract.TABLE, UserContract.COLUNS, null, null, null, null, null);
        Boolean flag = cursor.moveToFirst();
        db.close();
        helper.close();
        return flag;

    }
}
