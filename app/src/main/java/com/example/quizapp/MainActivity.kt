package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start_button=findViewById<Button>(R.id.start_button)
        val name: EditText =findViewById(R.id.name)
        start_button.setOnClickListener {
            if(name.text.isNotEmpty()){
                val intent= Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Enter Your Name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}