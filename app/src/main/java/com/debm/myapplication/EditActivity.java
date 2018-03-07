package com.debm.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class EditActivity extends AppCompatActivity {

    EditText etUsername1, etFullname1, etCity1, etStatus1;
    Button bEdit1;

    InterfaceRequest mResultCallback;
    String edit_url = "http://destanti.id/user/edit_user";

    User data_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent  intent = getIntent();
        Bundle bundle =  intent.getExtras();

        HashMap<String,String> params = new HashMap <>();

        assert bundle != null;
        data_user = bundle.getParcelable("data_user");

        etUsername1 = findViewById(R.id.etUsername1);
        etFullname1 = findViewById(R.id.etFullname1);
        etCity1 = findViewById(R.id.etCity1);
        etStatus1 = findViewById(R.id.etStatus1);
        bEdit1 = findViewById(R.id.bEdit1);

        etFullname1.setText(data_user.getFullname());
        etUsername1.setText(data_user.getUsername());
        etCity1.setText(data_user.getCity());
        etStatus1.setText(data_user.getStatus());


        bEdit1.setOnClickListener(view -> {

            params.put("id_user", String.valueOf(data_user.getId_user()));
            params.put("username", etUsername1.getText().toString());
            params.put("fullname", etFullname1.getText().toString());
            params.put("city", etCity1.getText().toString());
            params.put("status",etCity1.getText().toString());
            params.put("password", data_user.getPassword());


            initVolleyCallback();
            VolleyRequest.getInstance(this).startRequest(mResultCallback, edit_url, params, "editUser");

        });


    }

    void initVolleyCallback() {
        mResultCallback = (resultType, response) -> {
            Log.d("test", "Volley result " + resultType);
            Log.d("test", "Volley response" + response);
            VolleyRequest.setReturnValue(resultType, response);
            if (VolleyRequest.getReturnValue().get("resulttag").equals("success")){
                finish();
                Intent intent = new Intent(getApplicationContext(), SearchUser.class);
                startActivity(intent);
                Toast.makeText(this, "Edit User Success!", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("result", "initVolleyCallback: error! "+VolleyRequest.getReturnValue().get("data"));
                Toast.makeText(this, "Sorry, there's a problem. Try Again.", Toast.LENGTH_SHORT).show();
            }

        };
    }

}
