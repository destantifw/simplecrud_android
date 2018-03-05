package com.debm.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by destantifw on 3/5/2018.
 */

public class VolleyRequest {
        private static Map<String,String> params;
        private static RequestQueue queue;

        private String URL;
        public static HashMap<String,String> returnValue;

        InterfaceRequest mResultCallback = null;

        @SuppressLint("StaticFieldLeak")
        private static VolleyRequest mInstance;

        @SuppressLint("StaticFieldLeak")
        private static Context mContext;

        public VolleyRequest(Context context){
            mContext = context;
        }

        public static synchronized VolleyRequest getInstance(Context context) {
            if (mInstance == null) {
                mInstance = new VolleyRequest(context);
            }

            mContext = context;
//        queue = Volley.newRequestQueue(context);

            return mInstance;
        }


        public RequestQueue getRequestQueue() {
            if (queue == null) {
                // getApplicationContext() is key, it keeps you from leaking the
                // Activity or BroadcastReceiver if someone passes one in.
                queue = Volley.newRequestQueue(mContext);
            }
            return queue;
        }


        public <T> void addToRequestQueue(Request<T> req, String tag) {
            req.setTag(tag);
            getRequestQueue().add(req);
        }

        public void startRequest(InterfaceRequest resultCallback, String URL, final HashMap<String,String> params, String tag){

            mResultCallback = resultCallback;
            setURL(URL);
            setParams(params);

                StringRequest stringRequest = new StringRequest(StringRequest.Method.POST,
                        getURL(),
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("response", "valid response\n"+VolleyRequest.getParams()+"\n"+response);

                                if(mResultCallback != null)
                                    try {
                                        mResultCallback.notifySuccess("success",response);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                            }

                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                if(mResultCallback != null)
                                    try {
                                        mResultCallback.notifySuccess("error",error.toString());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                            }
                        }
                ){
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  paramsfinal;
                        paramsfinal = VolleyRequest.getParams();
                        Log.d("response", "getParams: "+paramsfinal);
                        return paramsfinal;
                    }
                };


                getRequestQueue().cancelAll(tag);
                addToRequestQueue(stringRequest,tag);

        }

// GETTER AND SETTER

        private String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }

        public static Map <String, String> getParams() {
            return params;
        }

        public void setParams(Map <String, String> params) {
            VolleyRequest.params = params;
        }

        public static HashMap <String, String> getReturnValue() {
            if (returnValue!=null)
                Log.d("result", "getReturnValue: "+returnValue.keySet());

            return returnValue;
        }

        public static void setReturnValue(String result, String returnValue1) {
            HashMap<String,String> returnValuetemp = new HashMap <>();
            returnValuetemp.put("resulttag",result);
            returnValuetemp.put("data", returnValue1);

            returnValue = returnValuetemp;

            Log.d("result", "setReturnValue: "+ returnValue.keySet());
        }



}
