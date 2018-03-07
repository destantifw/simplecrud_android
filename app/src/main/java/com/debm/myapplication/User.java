package com.debm.myapplication;

/**
 * Created by destantifw on 3/5/2018.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    int id_user;
    String username;
    String password;
    String fullname;
    String city;
    String status;

    public User(int id_user, String username, String password, String fullname, String city, String status) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.city = city;
        this.status = status;
    }

    protected User(Parcel in) {
        username = in.readString();
        password = in.readString();
        fullname = in.readString();
        city = in.readString();
        status = in.readString();
    }

    public static final Creator <User> CREATOR = new Creator <User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity() {
        return city;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_user);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(fullname);
        dest.writeString(city);
        dest.writeString(status);
    }
}
