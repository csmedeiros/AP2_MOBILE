package com.example.ap2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

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
        val bundle = Bundle()

        nome.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && nome.text.contentEquals("Insira aqui seu nome")) {
                nome.text.clear()
            } else if (hasFocus.not() && nome.text.contentEquals("")) {
                nome.setText("Insira aqui seu nome")
            }
        }

        idade.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && idade.text.contentEquals("Insira aqui sua idade")) {
                idade.text.clear()
            } else if (hasFocus.not() && idade.text.contentEquals("")) {
                idade.setText("Insira aqui sua idade")
            }
        }

        matricula.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && matricula.text.contentEquals("Insira aqui sua matrícula")) {
                matricula.text.clear()
            } else if (hasFocus.not() && matricula.text.contentEquals("")) {
                matricula.setText("Insira aqui sua matrícula")
            }
        }

        pesquisa.setOnClickListener {
            if (!nome.text.contentEquals("") &&
                !nome.text.contentEquals("Insira aqui seu nome") &&
                !idade.text.contentEquals("") &&
                !idade.text.contentEquals("Insira aqui sua idade") &&
                !matricula.text.contentEquals("") &&
                !matricula.text.contentEquals("Insira aqui sua matrícula")
            ) {
                val infos = ArrayList<String>()
                infos.add(nome.text.toString())
                infos.add(idade.text.toString())
                infos.add(matricula.text.toString())

                bundle.putStringArrayList("infos", infos)

                val intent = Intent(this@MainActivity, Pesquisa1::class.java)
                intent.putExtras(bundle)
                Log.d("MainActivity", intent.extras.toString())
                startActivity(intent)
            } else {
                erro.visibility = View.VISIBLE
            }
        }
    }
}
