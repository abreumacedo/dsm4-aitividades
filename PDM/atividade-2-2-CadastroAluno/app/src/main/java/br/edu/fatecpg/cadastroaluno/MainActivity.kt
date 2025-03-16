package br.edu.fatecpg.cadastroaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializando os componentes da tela depois de setar o layout
        val edtNomeAluno = findViewById<EditText>(R.id.edt_nome_aluno)
        val btnCadastar = findViewById<Button>(R.id.btn_cadastrar_aluno)

        btnCadastar.setOnClickListener {
            val nomeAluno = edtNomeAluno.text.toString()

            // Verifica se o nome do aluno foi digitado
            if (nomeAluno.isNotEmpty()) {
                // Criar e enviar a intent com o nome do aluno para a segunda tela
                val intent = Intent(this, SegundaTelaActivity::class.java)
                intent.putExtra("Nome_Aluno", nomeAluno)
                startActivity(intent)
            } else {
                edtNomeAluno.error = "Por favor, digite o nome do aluno."
            }
        }
    }
}
