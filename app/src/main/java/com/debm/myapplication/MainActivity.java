package com.debm.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    EditText etFullname;
    EditText etCity;
    EditText etStatus;
    Button bSubmit;

    InterfaceRequest mResultCallback;
    private String url_insert = "http://192.168.0.13/crud_android/user/insert_user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etFullname = findViewById(R.id.etFullname);
        etCity = findViewById(R.id.etCity);
        etStatus = findViewById(R.id.etStatus);
        bSubmit = findViewById(R.id.bSubmit);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               insertToDB(etUsername.getText().toString(), MD5(etPassword.getText().toString()), etFullname.getText().toString(),
                       etCity.getText().toString(), etStatus.getText().toString());
            }
        });

    }


    private void insertToDB(String username, String password, String fullname, String city, String status) {
        HashMap<String, String > params = new HashMap <>();

        params.put("username", username);
        params.put("password", password);
        params.put("fullname", fullname);
        params.put("city", city);
        params.put("status", status);

        initVolleyCallback();
        VolleyRequest.getInstance(this).startRequest(mResultCallback, url_insert, params, "insert_user");

    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return md5;
    }

    void initVolleyCallback() {
        mResultCallback = (resultType, response) -> {
            Log.d("test", "Volley result " + resultType);
            Log.d("test", "Volley response" + response);
            VolleyRequest.setReturnValue(resultType, response);
            if (VolleyRequest.getReturnValue().get("resulttag").equals("success")){
                Log.d("result", "initVolleyCallback: success! "+VolleyRequest.getReturnValue().get("data"));
            } else {
                Log.d("result", "initVolleyCallback: error! "+VolleyRequest.getReturnValue().get("data"));
            }

        };
    }
}
