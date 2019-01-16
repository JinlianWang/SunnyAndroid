package com.sunnycorps.sunnyandroid

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.sunnycorps.network.RetrofitClient
import com.sunnycorps.network.models.Customer
import com.sunnycorps.network.services.CustomerServices

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val btn_get_customer = findViewById(R.id.btn_get_customer) as Button
        btn_get_customer.setOnClickListener {
            RetrofitClient.getInstance().getCustomerById("1", object: Callback<Customer> {
                override fun onFailure(call: Call<Customer>?, t: Throwable?) {
                    Log.v("retrofit", "call failed")
                }

                override fun onResponse(call: Call<Customer>?, response: Response<Customer>?) {
                    var customer = response?.body()
                    Log.v("retrofit", "Customer: " + customer?.firstName + " lastName: " + customer?.lastName)
                }

            });
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}

