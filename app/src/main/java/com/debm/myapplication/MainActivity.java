package com.debm.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    EditText etFullname;
    EditText etCity;
    EditText etStatus;
    Button bSubmit;
    Button bLogin;
    Button bSeeUser;

    InterfaceRequest mResultCallback;


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
        bLogin = findViewById(R.id.bLogin);
        bSeeUser = findViewById(R.id.bSeeUser);

        bSubmit.setOnClickListener(view -> insertToDB(etUsername.getText().toString(), etPassword.getText().toString(), etFullname.getText().toString(),
                etCity.getText().toString(), etStatus.getText().toString()));

        bLogin.setOnClickListener(view -> {

            Intent loginPageIntent = new Intent(getApplicationContext(),LoginPage.class);
            startActivity(loginPageIntent);
        });

        bSeeUser.setOnClickListener(view -> {

            Intent searchPageIntent = new Intent(getApplicationContext(),SearchUser.class);
            startActivity(searchPageIntent);
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
        String url_insert = "http://destanti.id/user/insert_user";
        VolleyRequest.getInstance(this).startRequest(mResultCallback, url_insert, params, "insert_user");

    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ignored) {
        }
        return md5;
    }

    void initVolleyCallback() {
        mResultCallback = (resultType, response) -> {
            Log.d("test", "Volley result " + resultType);
            Log.d("test", "Volley response" + response);
            VolleyRequest.setReturnValue(resultType, response);
            if (VolleyRequest.getReturnValue().get("resulttag").equals("success")){
                if (VolleyRequest.getReturnValue().get("data").equals("success")){
                    finish();
                    Intent loginPageIntent = new Intent(this, LoginPage.class);
                    startActivity(loginPageIntent);
                } else{
                    Toast.makeText(this, "Sorry, there's a problem. Try Again.", Toast.LENGTH_SHORT).show();
                }


                Log.d("result", "initVolleyCallback: success! "+VolleyRequest.getReturnValue().get("data"));


            } else {
                Log.d("result", "initVolleyCallback: error! "+VolleyRequest.getReturnValue().get("data"));
                Toast.makeText(this, "Sorry, there's a problem. Try Again.", Toast.LENGTH_SHORT).show();
            }

        };
    }
}
