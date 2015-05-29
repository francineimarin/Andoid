package com.example.administrador.myapplication.models.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.myapplication.models.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserContract {

    public static final String TABLE = "user";
    public static final String USER = "user";
    public static final String PASSWORD = "password";

    public static final String[] COLUNS = {USER, PASSWORD};

    public static String createTable() {
        final StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(USER + " TEXT, ");
        sql.append(PASSWORD + " TEXT ");
        sql.append(" ); ");
        return sql.toString();
    }

    public static String insertUserDefault() {
        final StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(USER +", ");
        sql.append(PASSWORD);
        sql.append(" ) ");
        sql.append(" VALUES ");
        sql.append(" ( ");
        sql.append("'Francinei', ");
        sql.append("'123456' ");
        sql.append(" ); ");
        return sql.toString();
    }

    public static ContentValues getContentValues(User user) {
        ContentValues content = new ContentValues();
        content.put(USER, user.getUser());
        content.put(PASSWORD, user.getPassword());
        return content;
    }

    public static User bind(Cursor cursor) {
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            User user = new User();
            user.setUser(cursor.getString(cursor.getColumnIndex(USER)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));
            return user;
        }
        return null;
    }

    public static List<User> bindList(Cursor cursor) {
        final List<User> user = new ArrayList<User>();
        while (cursor.moveToNext()) {
            user.add(bind(cursor));
        }
        return user;
    }

}
