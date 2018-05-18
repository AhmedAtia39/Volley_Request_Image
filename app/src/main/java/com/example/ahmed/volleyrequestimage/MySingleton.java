package com.example.ahmed.volleyrequestimage;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by AHMED on 18/05/2018.
 */

public class MySingleton {
    public RequestQueue rq;
    public Context mContext;

    public MySingleton(Context c) {
        mContext = c;

        if (rq == null) {
            rq = Volley.newRequestQueue(mContext.getApplicationContext());
        }
    }

    public RequestQueue getRQ() {
        return rq;
    }
}
