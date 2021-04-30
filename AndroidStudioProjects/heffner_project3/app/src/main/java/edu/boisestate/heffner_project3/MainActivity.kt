package edu.boisestate.heffner_project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apihost:String = BuildConfig.WEB_SERVER + "/api/v1/"

        if(BuildConfig.BUILD_TYPE == "release") {
            debugButton.visibility = View.GONE
        }
    }
}
