

package com.aradevs.volleytest

import android.content.Context
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.aradevs.volleytest.request.AppSingleton
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by Ar4 on 15/05/2019.
 */

class MainActivity : AppCompatActivity() {

    //TODO: Set your server URL
    private val defaultUrl:String= "https://pokeapi.co/api/v2/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get data from server
        requestDitto(applicationContext, getString(R.string.dittoEndpoint))

    }

    //Request data from server (GET)
    private fun requestDitto(context: Context, endpoint: String){
        //declaring request
        val jsonArrayRequest = JsonObjectRequest(defaultUrl+endpoint, null, Response.Listener {
                    response: JSONObject? ->
                        try{
                            //TODO: Handle your response
                            Log.e("response", response.toString())
                        }catch (e: JSONException){
                            e.printStackTrace()
                        }
            }, Response.ErrorListener {
                    error->
                        Log.e("Error", error.toString())
            }
        )

        //Adding request to our volley queue
        AppSingleton.getInstance(context)?.addToRequestQueue(jsonArrayRequest,context)
    }

}
