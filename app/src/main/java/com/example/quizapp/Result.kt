package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name:TextView=findViewById(R.id.name)
        val score:TextView=findViewById(R.id.score)
        val btnfinish: Button =findViewById(R.id.btn_finish)

        name.text=intent.getStringExtra(constants.USER_NAME)
        val totalQuestion=intent.getIntExtra(constants.TOTAL_QUESTIONS,0)
        val correctanswers=intent.getIntExtra(constants.CORRECT_ANSWER,0)
        score.text="Your Score is $correctanswers out of $totalQuestion"
        btnfinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))

        }

    }
}