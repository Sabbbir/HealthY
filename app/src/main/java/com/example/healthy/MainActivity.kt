package com.example.healthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workout_Login_cred_submit.setOnClickListener {
            val login_submit = Intent(this, MenuPage::class.java)
            startActivity(login_submit)
        }
        workout_sign_up.setOnClickListener {
            val sign_up = Intent(this, SignUp::class.java)
            startActivity(sign_up)
        }
    }
}