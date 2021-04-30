package com.electronicarmory.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var totalcase: String
        lateinit var totaldeaths: String
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)



        val finalText = findViewById<TextView>(R.id.textView)

        finalText.text = "Hello click for updates"


        val serviceDownloader = CoronaService()

        val callback = object : Callback<BpiResponse> {
            override fun onFailure(call: Call<BpiResponse>?, t: Throwable?) {
                Log.e("MainActivity", "Problems", t)

            }

            override fun onResponse(call: Call<BpiResponse>?, response: Response<BpiResponse>?) {
                response?.isSuccessful.let {
                    Log.d("Response", response.toString())
                    Log.d("Response", response?.body().toString())
                    val resp = response?.body()?.Global


                    totalcase = resp?.TotalConfirmed.toString()
                    totaldeaths = resp?.TotalRecovered.toString()

                    val firstFragment = FirstFragment.newInstance("$totalcase")
                    val secondFragment = SecondFragment.newInstance("$totaldeaths")

                    // Place the fragment into the container



                    val casesButton = findViewById<Button>(R.id.buttoncases)
                    casesButton.setOnClickListener {
                        Log.d("BSU", firstFragment.toString())
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.casesLayout, firstFragment)
                            .addToBackStack(firstFragment.toString())
                            .commit()

                    }

                    val deathsButton = findViewById<Button>(R.id.buttondeaths)
                    deathsButton.setOnClickListener {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.deathsLayout, secondFragment)
                            .addToBackStack(secondFragment.toString())
                            .commit()

                    }

                    val previousButton = findViewById<Button>(R.id.back)
                    previousButton.setOnClickListener {
                        Log.d("BSU", secondFragment.toString())
                        supportFragmentManager.popBackStack()
                    }
                }
            }

        }
        serviceDownloader.getCoronaupdates(callback)


        val launchButton = findViewById<Button>(R.id.return1)
        launchButton.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

    }
}
