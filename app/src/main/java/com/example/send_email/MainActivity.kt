package com.example.send_email

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import javax.security.auth.Subject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail : EditText = findViewById(R.id.etEmail)
        val etSubject : EditText = findViewById(R.id.etSubject)
        val etMessage : EditText = findViewById(R.id.etMessage)
        val btSend : Button = findViewById(R.id.btSend)



        btSend.setOnClickListener {
                var email = etEmail.text.toString()
                var subject = etSubject.text.toString()
                var message = etMessage.text.toString()

                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                intent.putExtra(Intent.EXTRA_SUBJECT,subject)
                intent.putExtra(Intent.EXTRA_TEXT,message)

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"client"));




        }


    }
}