package com.example.ap2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class Pesquisa1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesquisa1)

        val extras = intent.extras

        fun recuperaDados():List<String> {
                val nome = extras?.getString("nome")
                val idade = extras?.getInt("idade")
                // Faça o que deseja com os dados recuperados
                // por exemplo, exiba-os em uma TextView ou realize alguma lógica com eles
                val dados: List<String> = listOf(nome.toString(), idade.toString())
                return dados
        }

        val recepcaoStr = "Olá " + recuperaDados()[0] + ", seja bem vindo!\n Vamos começar seu teste..."
        val recepcao = findViewById<TextView>(R.id.tvRecepcao)

        recepcao.setText(recepcaoStr)
    }
}
