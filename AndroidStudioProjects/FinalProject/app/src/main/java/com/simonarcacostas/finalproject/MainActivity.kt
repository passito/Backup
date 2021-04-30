package com.simonarcacostas.finalproject

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class MainActivity : AppCompatActivity(), SensorEventListener {

    private var sensorManager:SensorManager?=null;

    private var moving = false;
    private var totalSteps:Float = 0F
    private var previousSteps:Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        moving = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if(stepSensor == null) {
            Toast.makeText(this,"No sensor detected",Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var current = findViewById<TextView>(R.id.current) as TextView
        val circularProgressBar = findViewById<CircularProgressBar>(R.id.CircularProgressbar)
        if(moving) {
            totalSteps = event!!.values[0]
            val currentSteps = totalSteps.toInt() - previousSteps.toInt()
            current.text = ("$currentSteps")


            circularProgressBar.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }

    }

    fun resetSteps() {

    }
}