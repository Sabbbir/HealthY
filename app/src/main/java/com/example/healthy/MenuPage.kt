package com.example.healthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_page.*

class MenuPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)

        personalize.setOnClickListener {
        val personalize = Intent(this, Personalize::class.java)
            startActivity(personalize)
        }
        ex_suggestion.setOnClickListener {
            val ex_suggestion = Intent(this, ExerciseSuggestion::class.java)
            startActivity(ex_suggestion)
        }
        users_choice.setOnClickListener {
            val userschoice = Intent(this, UserChoiceExercise::class.java)
            startActivity(userschoice)
        }
        do_and_dont.setOnClickListener {
            val doanddont = Intent(this, DosandDonts::class.java)
            startActivity(doanddont)
        }
        dietchart.setOnClickListener {
            val dietchart = Intent(this, DietChart::class.java)
            startActivity(dietchart)
        }

    }
}