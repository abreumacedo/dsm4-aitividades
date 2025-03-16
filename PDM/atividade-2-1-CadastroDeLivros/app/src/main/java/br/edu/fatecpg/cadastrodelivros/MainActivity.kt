package br.edu.fatecpg.cadastrodelivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tituloLivroEditText  = findViewById<EditText>(R.id.edt_titulo_livro)
        val autorLivroEditText   = findViewById<EditText>(R.id.edt_autor_livro)
        val cadastrarLivroButton = findViewById<Button>(R.id.btn_cadastrar_livro)

        cadastrarLivroButton.setOnClickListener {
            val titulo = tituloLivroEditText.text.toString()
            val autor  = autorLivroEditText.text.toString()

            if (titulo.isEmpty() || autor.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, LivroDetalhesActivity::class.java)
                intent.putExtra("titulo", titulo)
                intent.putExtra("autor", autor)
                startActivity(intent)
            }
        }
    }
}
