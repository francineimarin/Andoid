package com.example.administrador.myapplication.models.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private Integer mId;
    private String mUser;
    private String mPassword;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String mUser) {
        this.mUser = mUser;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (mId != null ? !mId.equals(user.mId) : user.mId != null) return false;
        if (mUser != null ? !mUser.equals(user.mUser) : user.mUser != null) return false;
        return !(mPassword != null ? !mPassword.equals(user.mPassword) : user.mPassword != null);

    }

    @Override
    public int hashCode() {
        int result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mUser != null ? mUser.hashCode() : 0);
        result = 31 * result + (mPassword != null ? mPassword.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mId);
        dest.writeValue(this.mUser);
        dest.writeValue(this.mPassword);
    }
}
