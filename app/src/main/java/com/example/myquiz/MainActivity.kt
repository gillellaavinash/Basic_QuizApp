package com.example.myquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)

        val txt=findViewById<TextView>(R.id.txt)

        btn.setOnClickListener {

            if(txt.text.isEmpty())
            {
                Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this , QuizQuestions:: class.java)
                intent.putExtra(Constants.USER_NAME , txt.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}