package com.example.coffeemid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderPlaced : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_placed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // GET ELEMENTS
        // Roast
        val roast_textview = findViewById<TextView>(R.id.roast_textview)

        // Creamer
        val dairyCreamer_textview = findViewById<TextView>(R.id.dairyCreamer_textview)
        val nondairyCreamer = findViewById<TextView>(R.id.nondairyCreamer_textview)
        val hahCreamer = findViewById<TextView>(R.id.hahCreamer_textview)

        // Pumps
        val vanillaPump = findViewById<TextView>(R.id.vanillaPump_textview)
        val hazlePump = findViewById<TextView>(R.id.hazlePump_textview)
        val coconutPump = findViewById<TextView>(R.id.coconutPump_textview)
        val rasberryPump = findViewById<TextView>(R.id.rasberryPump_textview)
        val mangoPump = findViewById<TextView>(R.id.mangoPump_textview)
        val chocoPump = findViewById<TextView>(R.id.chocoPump_textview)

        // Toppings
        val whipTopping = findViewById<TextView>(R.id.whipTopping_textview)
        val foamTopping = findViewById<TextView>(R.id.foamTopping_textview)
        val caramelTopping = findViewById<TextView>(R.id.caramelTopping_textview)

        val notes = findViewById<TextView>(R.id.AdditionalNote_textview)
        // GET VALUES
        // Roast
        val roastVal = intent.getStringExtra("ROAST");

        // Creamers
        val dairyCreamerVal = intent.getBooleanExtra("DAIRYCREAMER", false)
        val nondairyCreamerVal = intent.getBooleanExtra("NONDAIRYCREAMER", false)
        val hahdairyCreamerVal = intent.getBooleanExtra("HAHDAIRYCREAMER", false)

        // Pumps
        val vanillaPumpVal = intent.getBooleanExtra("VANILLAPUMP", false)
        val hazlePumpVal = intent.getBooleanExtra("HAZLEPUMP", false)
        val coconutPumpVal = intent.getBooleanExtra("COCONUTPUMP", false)
        val rasberryPumpVal = intent.getBooleanExtra("RASBERRYPUMP", false)
        val mangoPumpVal = intent.getBooleanExtra("MANGOPUMP", false)
        val chocoPumpVal = intent.getBooleanExtra("CHOCOPUMP", false)

        // toppings
        val whipToppingVal = intent.getBooleanExtra("WHIPTOPPING", false)
        val foamToppingVal = intent.getBooleanExtra("FOAMTOPPING", false)
        val caramelToppingVal = intent.getBooleanExtra("CARAMELTOPPING", false)

        // SET LABELS
        roast_textview.text = roastVal

        // Helper to display yes/no
        fun boolToYesNo(value: Boolean) = if (value) "Yes" else "No"

        // Creamers
        dairyCreamer_textview.text = boolToYesNo(dairyCreamerVal)
        nondairyCreamer.text = boolToYesNo(nondairyCreamerVal)
        hahCreamer.text = boolToYesNo(hahdairyCreamerVal)

        // Pumps
        vanillaPump.text = boolToYesNo(vanillaPumpVal)
        hazlePump.text = boolToYesNo(hazlePumpVal)
        coconutPump.text = boolToYesNo(coconutPumpVal)
        rasberryPump.text = boolToYesNo(rasberryPumpVal)
        mangoPump.text = boolToYesNo(mangoPumpVal)
        chocoPump.text = boolToYesNo(chocoPumpVal)

        // Toppings
        whipTopping.text = boolToYesNo(whipToppingVal)
        foamTopping.text = boolToYesNo(foamToppingVal)
        caramelTopping.text = boolToYesNo(caramelToppingVal)

        // Notes
        val notesVal = intent.getStringExtra("NOTES")
        notes.text = if (!notesVal.isNullOrBlank()) notesVal else "None"


    }
}
