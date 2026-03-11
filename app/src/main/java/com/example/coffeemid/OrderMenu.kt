package com.example.coffeemid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // SELECTIONS
        // Roast
        val RoastGroup = findViewById<RadioGroup>(R.id.roast_radio)
        val roastSelectId = RoastGroup.checkedRadioButtonId // Get the id of selected button
        val roastValue = findViewById<Button>(roastSelectId)?.text.toString() // Get the text of the selected button

        // Creamer
        val dairyCreamer = findViewById<CheckBox>(R.id.dairyCreamer)
        val nondairyCreamer = findViewById<CheckBox>(R.id.nondairyCreamer)
        val hahCreamer = findViewById<CheckBox>(R.id.hahCreamer)

        // Pumps
        val vanillaPump = findViewById<CheckBox>(R.id.vanillaPump)
        val hazlePump = findViewById<CheckBox>(R.id.hazlePump)
        val coconutPump = findViewById<CheckBox>(R.id.coconutPump)
        val rasberryPump = findViewById<CheckBox>(R.id.rasberryPump)
        val mangoPump = findViewById<CheckBox>(R.id.mangoPump)
        val chocoPump = findViewById<CheckBox>(R.id.chocoPump)

        // Toppings
        val whipTopping = findViewById<CheckBox>(R.id.whipTopping)
        val foamTopping = findViewById<CheckBox>(R.id.foamTopping)
        val caramelTopping = findViewById<CheckBox>(R.id.caramelTopping)

        // Note box
        val noteEditor = findViewById<EditText>(R.id.noteEditor)

        // BUTTONS
        val OrderBtn = findViewById<Button>(R.id.submit_order)

        // LISTENERS
        OrderBtn.setOnClickListener {
            // Read roast here so the selection is captured at click time
            val roastSelectId = RoastGroup.checkedRadioButtonId
            val roastValue = if (roastSelectId != -1) findViewById<RadioButton>(roastSelectId)?.text.toString() else "None"

            val orderIntent = Intent(this, OrderPlaced::class.java)
            //Roast
            orderIntent.putExtra("ROAST", roastValue)
            // Creamers
            orderIntent.putExtra("DAIRYCREAMER", dairyCreamer.isChecked)
            orderIntent.putExtra("NONDAIRYCREAMER", nondairyCreamer.isChecked)
            orderIntent.putExtra("HAHDAIRYCREAMER", hahCreamer.isChecked)
            // Pumps
            orderIntent.putExtra("VANILLAPUMP", vanillaPump.isChecked)
            orderIntent.putExtra("HAZLEPUMP", hazlePump.isChecked)
            orderIntent.putExtra("COCONUTPUMP", coconutPump.isChecked)
            orderIntent.putExtra("RASBERRYPUMP", rasberryPump.isChecked)
            orderIntent.putExtra("MANGOPUMP", mangoPump.isChecked)
            orderIntent.putExtra("CHOCOPUMP", chocoPump.isChecked)
            // toppings
            orderIntent.putExtra("WHIPTOPPING", whipTopping.isChecked)
            orderIntent.putExtra("FOAMTOPPING", foamTopping.isChecked)
            orderIntent.putExtra("CARAMELTOPPING", caramelTopping.isChecked)

            // Note box
            orderIntent.putExtra("NOTES", noteEditor.text.toString())

            // Send the intent
            startActivity(orderIntent)
            finish()
        }
    }
}
