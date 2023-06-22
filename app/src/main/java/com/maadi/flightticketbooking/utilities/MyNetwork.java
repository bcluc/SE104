package com.maadi.flightticketbooking.utilities;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyNetwork {
    private static MyNetwork mInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;

    private MyNetwork(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized MyNetwork getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyNetwork(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        }
        mRequestQueue.getCache().clear();

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setRetryPolicy(
                new DefaultRetryPolicy(10000,
                        1,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        getRequestQueue().add(req);
    }
}
