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

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.distance)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnResult = findViewById<Button>(R.id.btnResult)
        val edtDistance = findViewById<TextInputEditText>(R.id.edtDistance)

        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consumption = intent.getFloatExtra(KEY_CONSUMPTION, 0f)

        btnResult.setOnClickListener {

            val strDistance = edtDistance.text.toString()

            if (strDistance == "") {
                Snackbar
                    .make(
                        edtDistance,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {

                val distance = strDistance.toFloat()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_PRICE, price)
                intent.putExtra(KEY_CONSUMPTION, consumption)
                intent.putExtra(KEY_DISTANCE, distance)
                startActivity(intent)
            }
        }
    }
}