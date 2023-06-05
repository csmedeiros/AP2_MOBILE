package com.example.ap2

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var isIdadeFirstClick = true
    private var isNomeFirstClick = true
    private var isMatriculaFirstClick = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesquisa = findViewById<Button>(R.id.btnPesquisa)
        val nome = findViewById<EditText>(R.id.etNome)
        val idade = findViewById<EditText>(R.id.etIdade)
        val matricula = findViewById<EditText>(R.id.etMatricula)
        val erro = findViewById<TextView>(R.id.tvErroNomeIdade)

        nome.inputType = android.text.InputType.TYPE_CLASS_TEXT
        idade.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        matricula.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        erro.visibility = View.INVISIBLE
        erro.setTextColor(Color.RED)

        nome.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                nome.text.clear()
            } else if (!hasFocus && nome.text.isEmpty()) {
                nome.setText("Nome")
            }
        }

        idade.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus and isIdadeFirstClick) {
                idade.text.clear()
            } else if (!hasFocus && idade.text.isEmpty()) {
                idade.setText("Idade")
            }
        }
        matricula.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus and isMatriculaFirstClick) {
                matricula.text.clear()
            } else if (!hasFocus && matricula.text.isEmpty()) {
                matricula.setText("Matrícula")
            }
        }

        pesquisa.setOnClickListener {
                if (nome.text.isNotEmpty() && !nome.text.contentEquals("Insira aqui seu nome") and idade.text.isNotEmpty()
                    and !idade.text.contentEquals("Insira aqui sua idade") and matricula.text.isNotEmpty()   and !matricula.text.contentEquals("Insira aqui sua matrícula")) {
                val bundle = Bundle()
                bundle.putString("nome", nome.text.toString())
                bundle.putInt("idade", idade.text.toString().toInt())

                val intent = Intent(this, Pesquisa1::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                erro.visibility = View.VISIBLE
            }
        }
    }
}
