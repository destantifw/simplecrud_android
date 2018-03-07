package com.debm.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.HashMap;

public class LoginPage extends AppCompatActivity {

    InterfaceRequest mResultCallback;
    EditText etUsernameLogin;
    EditText etPasswordLogin;

    Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

//        finish();
//        Intent searchIntent = new Intent(this, SearchUser.class);
//        startActivity(searchIntent);

        etUsernameLogin = findViewById(R.id.etUsernameLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);

        bLogin = findViewById(R.id.bLogin2);
        MainActivity ma = new MainActivity();

        HashMap<String, String> params = new HashMap <>();

        params.put("username", etUsernameLogin.getText().toString());
        params.put("password", etPasswordLogin.getText().toString());

        bLogin.setOnClickListener(view -> {
           initVolleyCallback();
            String loginURL = "http://destanti.id/user/login";
            VolleyRequest.getInstance(this).startRequest(mResultCallback, loginURL, params, "loginUser");

        });

    }

    void initVolleyCallback() {
        mResultCallback = (resultType, response) -> {
            Log.d("test", "Volley result " + resultType);
            Log.d("test", "Volley response" + response);
            VolleyRequest.setReturnValue(resultType, response);
            if (VolleyRequest.getReturnValue().get("resulttag").equals("success")){
                Intent searchIntent = new Intent(getApplicationContext(), SearchUser.class);
                startActivity(searchIntent);
                Log.d("result", "initVolleyCallback: success! "+VolleyRequest.getReturnValue().get("data"));


            } else {
                Log.d("result", "initVolleyCallback: error! "+VolleyRequest.getReturnValue().get("data"));
                Toast.makeText(this, "Sorry, there's a problem. Try Again.", Toast.LENGTH_SHORT).show();
            }

        };
    }


}
