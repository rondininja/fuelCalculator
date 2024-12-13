package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class ConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumption)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.consumption)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        val edtConsumption = findViewById<TextInputEditText>(R.id.edtConsumption)

        val price = intent.getFloatExtra(KEY_PRICE, 0f)

        btnNext.setOnClickListener {

            val strConsumption = edtConsumption.text.toString()

            if (strConsumption == "") {
                Snackbar
                    .make(
                        edtConsumption,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {

                val consumption = strConsumption.toFloat()
                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(KEY_PRICE, price)
                intent.putExtra(KEY_CONSUMPTION, consumption)
                startActivity(intent)
            }


        }
    }
}