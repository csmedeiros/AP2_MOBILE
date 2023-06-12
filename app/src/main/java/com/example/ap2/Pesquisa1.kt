package com.example.ap2

import Pesquisa2
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Pesquisa1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesquisa1)

        val extras = intent.extras

        fun recuperaDados():List<String> {
                val nome = extras?.getString("nome")
                val idade = extras?.getInt("idade")
                val matricula = extras?.getInt("matricula")
                // Faça o que deseja com os dados recuperados
                // por exemplo, exiba-os em uma TextView ou realize alguma lógica com eles
                val dados: List<String> = listOf(nome.toString(), idade.toString(), matricula.toString())
                return dados
        }

        val recepcaoStr = "Olá " + recuperaDados()[0] + ", seja bem vindo!\n Primeiramente selecione seu curso"
        val recepcao = findViewById<TextView>(R.id.tvRecepcao)
        val cdia = findViewById<RadioButton>(R.id.cbCDIA)
        val engcomp = findViewById<RadioButton>(R.id.cbENGCOMP)
        val ads = findViewById<RadioButton>(R.id.cbADS)
        val groupCursos = findViewById<RadioGroup>(R.id.rgCursos)
        val prox = findViewById<Button>(R.id.btnProx)
        val erro = findViewById<TextView>(R.id.tvErroRadioButton)
        erro.setTextColor(Color.RED)
        erro.visibility = View.INVISIBLE
        val bundle = Bundle()
        
        groupCursos.setOnCheckedChangeListener { _, checkedId ->
                    if(ads.isChecked || engcomp.isChecked || cdia.isChecked) {
                        bundle.putString("curso", "ADS")
                        Log.d("Pesquisa1", checkedId.toString())
                        erro.visibility = View.INVISIBLE
                        prox.setOnClickListener {
                            val intent = Intent(this@Pesquisa1, Pesquisa2::class.java)
                            intent.putExtras(bundle)
                            startActivity(intent)
                        }
                    }
                    else {
                        erro.visibility = View.VISIBLE
                        }
                }
        recepcao.setText(recepcaoStr)
    }
}