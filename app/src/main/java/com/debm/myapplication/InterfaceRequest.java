package com.debm.myapplication;

import org.json.JSONException;

/**
 * Created by destantifw on 3/5/2018.
 */

public interface InterfaceRequest {
    public void notifySuccess(String resultType,String response) throws JSONException;
}
