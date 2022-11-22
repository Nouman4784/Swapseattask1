package com.example.swapseattask1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val splash =  findViewById<LinearLayout>(R.id.splash)
        Handler().postDelayed({
            splash.visibility = View.GONE
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}