package br.edu.fatecpg.cadastroaluno

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SegundaTelaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        // Recuperando o nome do aluno enviado pela primeira tela
        val nomeAluno = intent.getStringExtra("Nome_Aluno")

        // Inicializando os componentes da interface
        val btnGerarMatricula = findViewById<Button>(R.id.btn_gerar_matricula)
        val txvMatricula = findViewById<TextView>(R.id.txv_matricula)

        txvMatricula.text = "Nome: $nomeAluno"

        // Configurando o clique do botão para gerar uma nova matrícula
        btnGerarMatricula.setOnClickListener {
            val numeroMatricula = Random.nextInt(100, 999)
            txvMatricula.text = "Nome: $nomeAluno\nMatrícula: $numeroMatricula"
        }
    }
}
