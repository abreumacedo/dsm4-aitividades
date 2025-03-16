package br.edu.fatecpg.conversordetemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtCelcius:     EditText    = findViewById(R.id.edt_celsius)
        val btnConverter:   Button      = findViewById(R.id.btn_converter)
        val txvResultado:   TextView    = findViewById(R.id.txv_resultado)

        btnConverter.setOnClickListener {
            val celcius = edtCelcius.text.toString()

            if (celcius.isNotEmpty()) {
                val fahrenheit = (celcius.toDouble() * 9/5) + 32

                txvResultado.text = "Resultado: $fahrenheit °F"
            }
            else {
                txvResultado.text = "Por favor, insira um resultado em Celcius"
            }

        }
    }
}