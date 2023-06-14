package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Pagina1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina1)

        val pesquisa = findViewById<Button>(R.id.btnPesquisa)
        val nomeVitima = findViewById<EditText>(R.id.etNomeVitima)
        val idadeVitima = findViewById<EditText>(R.id.etIdadeVitima)
        val nomeAutor = findViewById<EditText>(R.id.etNomeAutor)
        val idadeAutor = findViewById<EditText>(R.id.etIdadeAutor)

        nomeAutor.inputType = android.text.InputType.TYPE_CLASS_TEXT
        idadeAutor.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        idadeVitima.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        nomeVitima.inputType = android.text.InputType.TYPE_CLASS_TEXT
        val bundle = Bundle()

        nomeVitima.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && nomeVitima.text.contentEquals("Nome da Vítima")) {
                nomeVitima.text.clear()
            } else if (hasFocus.not() && nomeVitima.text.contentEquals("")) {
                nomeVitima.setText("Nome da Vítima")
            }
        }

        idadeVitima.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && idadeVitima.text.contentEquals("Idade da Vítima")) {
                idadeVitima.text.clear()
            } else if (hasFocus.not() && idadeVitima.text.contentEquals("")) {
                idadeVitima.setText("Idade da Vítima")
            }
        }

        idadeAutor.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && idadeAutor.text.contentEquals("Idade do Autor")) {
                idadeAutor.text.clear()
            } else if (hasFocus.not() && idadeAutor.text.contentEquals("")) {
                idadeAutor.setText("Idade do Autor")
            }
        }
        nomeAutor.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && nomeAutor.text.contentEquals("Nome do Autor")) {
                nomeAutor.text.clear()
            } else if (hasFocus.not() && nomeAutor.text.contentEquals("")) {
                nomeAutor.setText("Nome do Autor")
            }
        }

        pesquisa.setOnClickListener {
            if (!nomeVitima.text.contentEquals("") &&
                !nomeVitima.text.contentEquals("Nome da Vítima") &&
                !idadeVitima.text.contentEquals("") &&
                !idadeVitima.text.contentEquals("Idade da Vítima") &&
                !idadeAutor.text.contentEquals("") &&
                !idadeAutor.text.contentEquals("Idade do Autor") &&
                !nomeAutor.text.contentEquals("") &&
                !nomeAutor.text.contentEquals("Nome do Autor")
            ) {
                val infos = ArrayList<String>()
                infos.add(nomeVitima.text.toString())
                infos.add(idadeVitima.text.toString())
                infos.add(idadeAutor.text.toString())
                infos.add(nomeAutor.text.toString())

                bundle.putStringArrayList("infos", infos)

                val intent = Intent(this@Pagina1, Pagina2::class.java)
                intent.putExtras(bundle)
                Log.d("Pagina1", "Pagina1")
                Log.d("MainActivity", intent.extras.toString())
                startActivity(intent)
            }
        }
    }
}
