package com.debm.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by destantifw on 3/5/2018.
 */

public class SearchUserAdapter  extends RecyclerView.Adapter<SearchUserAdapter.UserHolder> {

    private Context mcontext;
    private List<User> userList;
    InterfaceRequest mResultCallback;


    public class UserHolder extends RecyclerView.ViewHolder {
        public TextView tvfullname, tvstatus, tvcity;
        Button bEdit, bDelete;

        public UserHolder(View view) {
            super(view);

            tvfullname = view.findViewById(R.id.tvfullname);
            tvstatus= view.findViewById(R.id.tvstatus);
            tvcity = view.findViewById(R.id.tvcity);
            bEdit = view.findViewById(R.id.bEdit);
            bDelete = view.findViewById(R.id.bDelete);

        }
    }

    public SearchUserAdapter(List<User> userList, Context context) {
        Log.d("masukadapter", "SearchUserAdapter: "+userList.size());
        this.userList = userList;
        mcontext = context;

    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new UserHolder(itemView);
    }


    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User user = userList.get(position);

        holder.tvfullname.setText(user.getFullname());
        holder.tvcity.setText(user.getCity());
        holder.tvstatus.setText(user.getStatus());

        holder.bEdit.setOnClickListener(view -> {
            Intent editIntent = new Intent(mcontext, EditActivity.class);
            editIntent.putExtra("data_user", user);

            mcontext.startActivity(editIntent);
        });
        HashMap<String,String> params = new HashMap <>();

        params.put("id_user", String.valueOf(user.getId_user()));

        String delete_url = "http://destanti.id/user/delete_user";

        holder.bDelete.setOnClickListener(view -> {

           initVolleyCallback();
           VolleyRequest.getInstance(mcontext).startRequest(mResultCallback,delete_url,params,"deleteRow");
        });
    }

    @Override
    public int getItemCount() {
        Log.d("masukadapter", "getItemCount: "+userList.size());
        return userList.size();
    }


    void initVolleyCallback() {
        mResultCallback = (resultType, response) -> {
            Log.d("test", "Volley result " + resultType);
            Log.d("test", "Volley response" + response);
            VolleyRequest.setReturnValue(resultType, response);
            if (VolleyRequest.getReturnValue().get("resulttag").equals("success")){
                Toast.makeText(mcontext, "Delete user success!.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (mcontext, SearchUser.class);

                mcontext.startActivity(intent);
                ((Activity)mcontext).finish();

            } else {
                Log.d("result", "initVolleyCallback: error! "+VolleyRequest.getReturnValue().get("data"));
                Toast.makeText(mcontext, "Sorry, there's a problem. Try Again.", Toast.LENGTH_SHORT).show();
            }

        };
    }

}

