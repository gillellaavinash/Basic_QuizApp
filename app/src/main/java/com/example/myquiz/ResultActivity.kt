package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView  = findViewById(R.id.username)
        val result : TextView  = findViewById(R.id.total)
        val button : Button    = findViewById(R.id.finishBtn)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        result.text = "You Score is $correctAnswers out of $totalQuestions"

        button.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}