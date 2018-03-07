package com.debm.myapplication;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchUser extends AppCompatActivity {

    RecyclerView rvUser ;
    SearchView svUser;

    InterfaceRequest mResultCallback;
    List<User> listUser = new ArrayList <>();
    SearchUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        rvUser = findViewById(R.id.rvUser);

        mAdapter = new SearchUserAdapter(listUser, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvUser.setLayoutManager(mLayoutManager);
        rvUser.setItemAnimator(new DefaultItemAnimator());
        rvUser.setAdapter(mAdapter);



//        svUser = findViewById(R.id.svUser);

        initVolleyCallback();
        String urlsearch = "http://destanti.id/user/get_user";
        VolleyRequest.getInstance(this).startRequest(mResultCallback,urlsearch,null,"getUser");
    }

    void initVolleyCallback() {
        mResultCallback = (resultType, response) -> {
            Log.d("test", "Volley result " + resultType);
            Log.d("test", "Volley response" + response);
            VolleyRequest.setReturnValue(resultType, response);
            if (VolleyRequest.getReturnValue().get("resulttag").equals("success")){

               showUser(VolleyRequest.getReturnValue().get("data"));

            } else {
                Log.d("result", "initVolleyCallback: error! "+VolleyRequest.getReturnValue().get("data"));
                Toast.makeText(this, "Sorry, there's a problem. Try Again.", Toast.LENGTH_SHORT).show();
            }

        };
    }

    private void showUser(String data) throws JSONException {

        Log.d("test", "showUser: ke sini");

        JSONArray jsonarray = new JSONArray(data);

        for (int i = 0; i <jsonarray.length(); i++) {
            Log.d("masukadapter", "showUser: "+jsonarray.length());
            JSONObject temp = jsonarray.getJSONObject(i);
            try {
                listUser.add(new User(
                        temp.getInt("id_user"),
                        temp.getString("username"),
                        temp.getString("password"),
                        temp.getString("fullname"),
                        temp.getString("city"),
                        temp.getString("status")
                ));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

//        mAdapter = new SearchUserAdapter(listUser, this);
        mAdapter.notifyDataSetChanged();

    }

}
