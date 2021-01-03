package com.example.instafire

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.main_screen.*


private val TAG = "main_screen"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
        btnLogin1.setOnClickListener {
            Log.i(TAG,"gopostactivity")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
        btnSignup1.setOnClickListener {
            Log.i(TAG,"gopostactivity")
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            finish()

        }
    }


}