package com.example.coffeemid

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

            val orderIntent = Intent(this, OrderPlaced::class.java)
            //Roast
            intent.putExtra("ROAST", roastValue)
            // Creamers
            intent.putExtra("DAIRYCREAMER", dairyCreamer.isChecked)
            intent.putExtra("NONDAIRYCREAMER", nondairyCreamer.isChecked)
            intent.putExtra("HAHDAIRYCREAMER", hahCreamer.isChecked)
            // Pump
            intent.putExtra("VANILLAPUMP", vanillaPump.isChecked)
            intent.putExtra("HAZLEPUMP", hazlePump.isChecked)
            intent.putExtra("COCONUTPUMP", coconutPump.isChecked)
            intent.putExtra("RASBERRYPUMP", rasberryPump.isChecked)
            intent.putExtra("MANGOPUMP", mangoPump.isChecked)
            intent.putExtra("CHOCOPUMP", chocoPump.isChecked)
            // toppings
            intent.putExtra("WHIPTOPPING", whipTopping.isChecked)
            intent.putExtra("FOAMTOPPING", foamTopping.isChecked)
            intent.putExtra("CARAMELTOPPING", caramelTopping.isChecked)

            // Note box
            intent.putExtra("NOTES", noteEditor.text.toString())

            // Send the intent
            startActivity(intent)
            finish()
        }
    }
}