package com.example.whatsappsender

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number: EditText = findViewById(R.id.number)
        val sendBtn: Button = findViewById(R.id.send_button)
        sendBtn.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.whatsapp")
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+91${number.text}"))
            try {
                startActivity(intent)
            }
            catch(e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")))
        }
    }
}

}