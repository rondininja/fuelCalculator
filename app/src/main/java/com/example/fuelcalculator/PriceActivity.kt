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

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.price)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        val edtPrice = findViewById<TextInputEditText>(R.id.edtPrice)

        btnNext.setOnClickListener {

            val strPrice = edtPrice.text.toString()

            if (strPrice == "") {
                Snackbar
                    .make(
                        edtPrice,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else{

                val price = strPrice.toFloat()
                val intent = Intent(this, ConsumptionActivity::class.java)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }
        }
    }
}