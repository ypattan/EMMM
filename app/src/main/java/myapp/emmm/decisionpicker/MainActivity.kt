package myapp.emmm.decisionpicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.decisionpicker.R

class MainActivity : AppCompatActivity() {
    var numberOptions = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_input)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        findViewById<Button>(R.id.enter_button).setOnClickListener{
            checkOptions()
        }

        findViewById<Button>(R.id.more_options_button).setOnClickListener{
            addMoreOptions(it)
        }

        findViewById<Button>(R.id.less_options_button).setOnClickListener{
            removeOptions(it)
        }
    }

    private fun checkOptions() {
        val optionA= findViewById<EditText>(R.id.option1).text.toString()
        val optionB= findViewById<EditText>(R.id.option2).text.toString()
        val optionC= findViewById<EditText>(R.id.option3).text.toString()
        val optionD= findViewById<EditText>(R.id.option4).text.toString()
        val optionE= findViewById<EditText>(R.id.option5).text.toString()

//        Log.d("BlankTest", "checking options - current # of open options: " + numberOptions)

        if (numberOptions == 2) {
            if (optionA == "" || optionB == "") {
                //toast that says both should be filled
                Toast.makeText(this@MainActivity, "Fill in at least 2 options", Toast.LENGTH_SHORT).show()
            }else{
                getAnswer()
            }
        } else if (numberOptions == 3) {
            if (optionA == "" || optionB == "" || optionC == "") {
                //toast that says both should be filled
                Toast.makeText(this@MainActivity, "Fill in all 3 options", Toast.LENGTH_SHORT).show()
            }else{
                getAnswer()
            }
        } else if (numberOptions == 4) {
            if (optionA == "" || optionB == "" || optionC == "" || optionD == "") {
                //toast that says both should be filled
                Toast.makeText(this@MainActivity, "Fill in all 4 options", Toast.LENGTH_SHORT).show()
            }else{
                getAnswer()
            }
        } else if (numberOptions == 5) {
            if (optionA == "" || optionB == "" || optionC == "" || optionD == "" || optionE == "") {
                //toast that says both should be filled
                Toast.makeText(this@MainActivity, "You need all 5 options", Toast.LENGTH_SHORT).show()
            }else{
                getAnswer()
            }
        }
    }

    fun addMoreOptions(view : View) {
        val option3 = findViewById<EditText>(R.id.option3)
        val option4 = findViewById<EditText>(R.id.option4)
        val option5 = findViewById<EditText>(R.id.option5)
        val addButton = findViewById<Button>(R.id.more_options_button)
        val removeButton = findViewById<Button>(R.id.less_options_button)

        if(option3.visibility == View.GONE){
            option3.visibility = View.VISIBLE
            option3.requestFocus()
            removeButton.visibility = View.VISIBLE
            numberOptions = 3
        } else if (option4.visibility == View.GONE){
            option4.visibility = View.VISIBLE
            option4.requestFocus()
            numberOptions = 4
        } else{
            option5.visibility = View.VISIBLE
            option5.requestFocus()
            addButton.visibility = View.INVISIBLE
            numberOptions = 5
        }
    }

    private fun removeOptions(view: View) {
        val option3 = findViewById<EditText>(R.id.option3)
        val option4 = findViewById<EditText>(R.id.option4)
        val option5 = findViewById<EditText>(R.id.option5)
        val addButton = findViewById<Button>(R.id.more_options_button)
        val removeButton = findViewById<Button>(R.id.less_options_button)

        if(option5.visibility == View.VISIBLE){
            option5.visibility = View.GONE
            option5.text = null
            numberOptions = 4
        } else if (option4.visibility == View.VISIBLE){
            option4.visibility = View.GONE
            option4.text = null
            numberOptions = 3
        } else{
            option3.visibility = View.GONE
            option3.text = null
            numberOptions = 2
            removeButton.visibility = View.INVISIBLE
        }
        addButton.visibility = View.VISIBLE
    }

    fun getAnswer() {

        val intent = Intent(this, AnswerActivity::class.java)

        val rand = (1..numberOptions).random()
        if(rand == 1) {
            intent.putExtra("Answer", findViewById<EditText>(R.id.option1).text.toString())
//            Log.d("BlankTest", "Chosen Answer " + rand + ": " + findViewById<EditText>(R.id.option1).text.toString())
//            intent.putExtra("Answer", numberOptions.toString())
        } else if (rand == 2) {
            intent.putExtra("Answer", findViewById<EditText>(R.id.option2).text.toString())
//            Log.d("BlankTest", "Chosen Answer " + rand + ": " + findViewById<EditText>(R.id.option2).text.toString())
//            intent.putExtra("Answer", numberOptions.toString())
        } else if (rand == 3) {
            intent.putExtra("Answer", findViewById<EditText>(R.id.option3).text.toString())
//            Log.d("BlankTest", "Chosen Answer " + rand + ": " + findViewById<EditText>(R.id.option3).text.toString())
//            intent.putExtra("Answer", numberOptions.toString())
        } else if (rand == 4) {
        intent.putExtra("Answer", findViewById<EditText>(R.id.option4).text.toString())
//            Log.d("BlankTest", "Chosen Answer " + rand + ": " + findViewById<EditText>(R.id.option4).text.toString())
//            intent.putExtra("Answer", numberOptions.toString())
        } else if (rand == 5) {
            intent.putExtra("Answer", findViewById<EditText>(R.id.option5).text.toString())
//            Log.d("BlankTest", "Chosen Answer " + rand + ": " + findViewById<EditText>(R.id.option5).text.toString())
//            intent.putExtra("Answer", numberOptions.toString())
        }

        startActivity(intent)
    }
}