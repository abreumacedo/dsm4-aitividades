package br.edu.fatecpg.calcularimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity(R.layout.activity_resultado) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        val imc = intent.getDoubleExtra("IMC", 0.0)

        val mensagem = when {
            imc < 17    -> "Muito abaixo do peso"
            imc < 18.49  -> "Abaixo do peso"
            imc < 24.99  -> "Peso normal"
            imc < 29.99    -> "Acima do peso"
            imc < 34.99    -> "Obesidade I"
            imc < 39.99 -> "Obesidade II (severa)"
            imc > 40    -> "Obesidade III (mórbida)"
            else -> "Obesidade"
        }
        txvResultado.text = "Seu IMC é %.2f\n%s".format(imc, mensagem)
    }
}