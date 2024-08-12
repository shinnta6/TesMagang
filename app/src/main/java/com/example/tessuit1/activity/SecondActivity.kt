package com.example.tessuit1.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tessuit1.R

class SecondActivity : AppCompatActivity() {
    private lateinit var selectedUserTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val usernameText = findViewById<TextView>(R.id.usernameText)
        selectedUserTextView = findViewById(R.id.selectedUserName)
        val chooseUserButton = findViewById<Button>(R.id.chooseUserButton)

        val name = intent.getStringExtra("name")
        usernameText.text = name

        chooseUserButton.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            val selectedUser = data?.getStringExtra("selectedUser")
            selectedUserTextView.text = selectedUser
        }
    }

    companion object {
        const val REQUEST_CODE = 100
    }

}