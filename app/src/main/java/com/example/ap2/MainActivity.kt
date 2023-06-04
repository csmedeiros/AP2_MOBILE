package com.example.ap2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var isIdadeFirstClick = true
    private var isNomeFirstClick = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pesquisa = findViewById<Button>(R.id.btnPesquisa)

        pesquisa.setOnClickListener {
            val intent = Intent(this, Pesquisa1::class.java)
            startActivity(intent)
        }
        val nome = findViewById<EditText>(R.id.etNome)
        val idade = findViewById<EditText>(R.id.etIdade)

        nome.inputType = android.text.InputType.TYPE_CLASS_TEXT
        idade.inputType = android.text.InputType.TYPE_CLASS_NUMBER

        nome.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus and nome.text.contains("Nome")) {
                nome.text.clear()
            }
            else {
                nome.setText("Nome")
            }
        }

        idade.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus and idade.text.contains("Idade")) {
                idade.text.clear()
            }
            else {
                idade.setText("Idade")
            }
        }
            }
        }
