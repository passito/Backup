package com.electronicarmory.databases

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        EventBus.getDefault().register(this)
        val cameraButton = findViewById<Button>(R.id.camerabutton)

        cameraButton.setOnClickListener {
            val cameraCheckPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

            if (cameraCheckPermission != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CAMERA
                    )
                ) {
                    val builder = AlertDialog.Builder(this)

                    val message = getString(R.string.permission_message)
                    builder.setTitle(R.string.permission_title)
                        .setMessage(message)
                        .setPositiveButton("OK") { _, _ ->
                            requestPermission()
                        }

                    val dialog = builder.create()
                    dialog.show()
                } else {
                    Log.d("BSU", "Should not show rationale")
                    requestPermission() // Will not display the request
                }
            } else {
                launchCamera()
            }
        }


        val mainTextView = findViewById<TextView>(R.id.name)
        val launchButton = findViewById<Button>(R.id.buttonname)
        launchButton.setOnClickListener {
            val intent = Intent(this, BroadcastActivity::class.java)
            startActivity(intent)
        }


        val buttonNext = findViewById<Button>(R.id.next)
        buttonNext.setOnClickListener {
            val intent = Intent(this, Handler::class.java)

            val text = mainTextView.getText().toString()

            intent.putExtra("texto", "$text")
            startActivity(intent)


        }
        buttonNext.isEnabled = false
    }

    private fun launchCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 9090)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 123)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for ((index, permission) in permissions.withIndex()) {
            if (permission == Manifest.permission.CAMERA) {
                if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                    launchCamera()
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 9090) {

            if (data != null) {
                val imageData: Bitmap = data.extras!!.get("data") as Bitmap

                val imageView = findViewById<ImageView>(R.id.imageView)
                imageView.setImageBitmap(imageData)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun OnEvent(event: RadioEvent) {
        Log.d("BSU", "${event.radioData}")

        val mainTextView = findViewById<TextView>(R.id.name)
        mainTextView.text = event.radioData
        val buttonNext = findViewById<Button>(R.id.next)
        if (mainTextView.text.isEmpty()) {
            buttonNext.isEnabled = false;
        } else {
            buttonNext.isEnabled = true;
        }


    }


    override fun onDestroy() {
        EventBus.getDefault().unregister(this)

        super.onDestroy()
    }
}