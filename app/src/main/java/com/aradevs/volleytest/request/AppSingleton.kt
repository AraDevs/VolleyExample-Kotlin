package com.aradevs.volleytest.request

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by Ar4 on 15/05/2019.
 */

class AppSingleton private constructor(context: Context) {


    // declaring useful variables
    private var requestQueue: RequestQueue? = null

    init {
        requestQueue = getRequestQueue(context)
    }

    //checking if there is a current request queue
    private fun getRequestQueue(context: Context): RequestQueue?
    {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.applicationContext)
        }
        return  requestQueue
    }

    //add request to the queue
    fun addToRequestQueue(req: Request<*>, context: Context) {
        getRequestQueue(context)?.add(req)
    }


    companion object {
        private var singleton: AppSingleton? = null

        @Synchronized
        fun getInstance(context: Context): AppSingleton? {
            if (singleton == null) {
                singleton = AppSingleton(context)
            }
            return singleton
        }
    }

}