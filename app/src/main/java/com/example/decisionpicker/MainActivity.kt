package com.example.decisionpicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_input)

        findViewById<Button>(R.id.enter_button).setOnClickListener{
            checkOptions()
        }
    }

    private fun checkOptions() {
        val optionA= findViewById<EditText>(R.id.option1).text.toString()
        val optionB= findViewById<EditText>(R.id.option1).text.toString()

        if (optionA == null || optionB == null) {
            //toast that says both should be filled
        } else {
            getAnswer()
        }
    }

    fun getAnswer() {
        val optionA= findViewById<EditText>(R.id.option1).text.toString()
        val optionB= findViewById<EditText>(R.id.option1).text.toString()

        val intent = Intent(this, AnswerActivity::class.java)

        val rand = (0..10).random()
        if(rand%2 == 0) {
            intent.putExtra("Answer", optionA)
        } else {
            intent.putExtra("Answer", optionB)
        }

        startActivity(intent)
    }
}