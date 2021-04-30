package com.simonarcacostas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var countA = 0
    var countB = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("BSU", savedInstanceState.toString())

    }


    fun countScoreA(view: View) {
        // increment the count for team A
        countA++
        val scoreteamA = findViewById<TextView>(R.id.scoreA) as TextView
        scoreteamA.text = "$countA"
    }

    fun countScoreB(view: View) {
        // increment the count for team B
        countB++
        val scoreteamB = findViewById<TextView>(R.id.scoreB) as TextView
        scoreteamB.text = "$countB"
    }

    fun startOver(view: View) {
        // restart both scores
        countA = 0
        countB = 0
        val scoreteamA = findViewById<TextView>(R.id.scoreA) as TextView
        scoreteamA.text = "00"
        val scoreteamB = findViewById<TextView>(R.id.scoreB) as TextView
        scoreteamB.text = "00"
    }

    fun viewResults(view: View) {
        val launch = Intent(this,Results::class.java)

        launch.putExtra("teamA", "$countA points")
        launch.putExtra("teamB", "$countB points")

        if (countA>countB){
            launch.putExtra("winner", "Team A wins $countA : $countB")
        }
        if (countA==countB){
            launch.putExtra("winner", "It is a draw $countA : $countB")
        }
        if (countA<countB){
            launch.putExtra("winner", "Team B wins $countA : $countB")
        }
        startActivity(launch)
    }

    fun random(view: View) {
        val launch = Intent(this,RandomNumber::class.java)
        startActivity(launch)
    }
    fun Board(view: View) {}
    fun substractA(view: View) {
        countA--
        val scoreteamA = findViewById<TextView>(R.id.scoreA) as TextView
        scoreteamA.text = "$countA"
    }
    fun substractB(view: View) {
        countB--
        val scoreteamB = findViewById<TextView>(R.id.scoreB) as TextView
        scoreteamB.text = "$countB"
    }
}
