package com.example.coffeemid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val orderBtn = findViewById<Button>(R.id.OrderBtn)
        val settingsBtn = findViewById<Button>(R.id.SettingsBtn)

        orderBtn.setOnClickListener {
            val intent = Intent(this, OrderMenu::class.java)
            startActivity(intent)
        }

        settingsBtn.setOnClickListener {
            print("not implemented")
//            val intent = Intent(this, Settings::class.java)
//            startActivity(intent)
        }
    }
}