package br.edu.fatecpg.cadastrodelivros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LivroDetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro_detalhes)

        val txvTituloLivro = findViewById<TextView>(R.id.txv_titulo_livro)
        val txvAutorLivro  = findViewById<TextView>(R.id.txv_autor_livro)

        val titulo = intent.getStringExtra("titulo")
        val autor  = intent.getStringExtra("autor")

        txvTituloLivro.text = "Título: $titulo"
        txvAutorLivro.text  = "Autor: $autor"

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        btnVoltar.setOnClickListener {

            finish()
        }

    }


}
