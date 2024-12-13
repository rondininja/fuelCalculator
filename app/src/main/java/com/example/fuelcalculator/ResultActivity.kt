package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE = "PriceActivity.KEY_PRICE"
const val KEY_CONSUMPTION = "ConsumptionActivity.KEY_CONSUMPTION"
const val KEY_DISTANCE = "DistanceActivity.KEY_DISTANCE"


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnReset = findViewById<Button>(R.id.btnReset)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consumption = intent.getFloatExtra(KEY_CONSUMPTION, 0f)
        val distance = intent.getFloatExtra(KEY_DISTANCE, 0f)

        tvResult.text = "R$ " + ((distance / consumption) * price).toString()

        btnReset.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}