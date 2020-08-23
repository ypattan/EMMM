package com.example.decisionpicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        setAnswer()

        findViewById<Button>(R.id.again_button).setOnClickListener{
            goTryAgain()
        }
    }

    private fun setAnswer() {
        val ans = findViewById<TextView>(R.id.answer)
        ans.text = intent.getStringExtra("Answer")
    }

    private fun goTryAgain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}