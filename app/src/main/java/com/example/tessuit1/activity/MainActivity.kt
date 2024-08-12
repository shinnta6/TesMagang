package com.example.tessuit1.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tessuit1.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val sentenceInput = findViewById<EditText>(R.id.sentenceInput)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        checkButton.setOnClickListener{
            val sentence = sentenceInput.text.toString().replace(" ", "")
            if (isPalindrome(sentence)) {
                showDialog("isPalindrome")
            } else {
                showDialog("not palindrome")
            }
        }
        nextButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", nameInput.text.toString())
            startActivity(intent)
        }
    }
    private fun isPalindrome(input: String): Boolean {
        return input.equals(input.reversed(), ignoreCase = true)
    }

    private fun showDialog(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}