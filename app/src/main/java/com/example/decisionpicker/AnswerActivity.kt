package com.example.decisionpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        setAnswer()
    }

    private fun setAnswer() {
        val ans = findViewById<TextView>(R.id.answer)
        ans.text = intent.getStringExtra("Answer")
    }
}