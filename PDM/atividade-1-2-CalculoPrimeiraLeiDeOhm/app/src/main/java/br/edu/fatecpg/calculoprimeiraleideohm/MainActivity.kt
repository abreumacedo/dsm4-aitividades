package br.edu.fatecpg.calculoprimeiraleideohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtTensao       = findViewById<EditText>(R.id.edt_tensao)
        val edtResistencia  = findViewById<EditText>(R.id.edt_resistencia)
        val edtCorrente     = findViewById<EditText>(R.id.edt_corrente)

        val btnCalcular     = findViewById<Button>(R.id.btn_calcular)

        val txvResultado    = findViewById<TextView>(R.id.txv_resultado)

        btnCalcular.setOnClickListener {
            val tensao = edtTensao.text.toString().toDoubleOrNull()
            val resistencia = edtResistencia.text.toString().toDoubleOrNull()
            val corrente = edtCorrente.text.toString().toDoubleOrNull()

            val camposPreenchidos = listOf(tensao, resistencia, corrente).count { it != null }

            val resultado = when {
                camposPreenchidos > 2 -> "Preencha apenas dois campos"
                camposPreenchidos < 2 -> "Preencha dois valores para calcular"
                tensao      != null && resistencia  != null -> "Corrente = %.2f A".format(tensao / resistencia)
                tensao      != null && corrente     != null -> "Resistência = %.2f R".format(tensao / corrente)
                resistencia != null && corrente     != null -> "Tensão = %.2f V".format(resistencia * corrente)
                else -> "Preencha dois valores para calcular"
            }

            txvResultado.text = resultado
        }

    }
}