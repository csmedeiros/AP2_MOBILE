package com.example.ap2

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
        val bundle = Bundle()

        fun recuperaDados(): ArrayList<String>? {
            val dados = extras?.getStringArrayList("infos")
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }
        Log.d("Pesquisa1", recuperaDados().toString())

        val recepcaoStr = "Olá " + recuperaDados()?.get(0) + ", seja bem vindo!\nPrimeiramente selecione seu curso"
        val recepcao = findViewById<TextView>(R.id.tvRecepcao)
        val cdia = findViewById<RadioButton>(R.id.cbCDIA)
        val engcomp = findViewById<RadioButton>(R.id.cbENGCOMP)
        val ads = findViewById<RadioButton>(R.id.cbADS)
        val groupCursos = findViewById<RadioGroup>(R.id.rgCursos)
        val prox = findViewById<Button>(R.id.btnProx)
        val erro = findViewById<TextView>(R.id.tvErroRadioButton)
        erro.setTextColor(Color.RED)
        erro.visibility = View.INVISIBLE

        groupCursos.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId > 0) {
                Log.d("Pesquisa1", checkedId.toString())
                erro.visibility = View.INVISIBLE
                prox.setOnClickListener {
                    val infos = ArrayList<String>()
                    // Passar nome, idade e matrícula para o bundle
                    val intent:Intent
                    when {
                        engcomp.isChecked -> {
                            bundle.putString("curso", engcomp.text.toString())
                            bundle.putStringArrayList("infos", recuperaDados())

                            intent = Intent(this@Pesquisa1, EngComp1::class.java)
                            intent.putExtras(bundle)
                            Log.d("Pesquisa1", bundle.toString())
                            startActivity(intent)
                        }
                        cdia.isChecked -> {
                            bundle.putString("curso", cdia.text.toString())
                            bundle.putStringArrayList("infos", recuperaDados())
                            intent = Intent(this@Pesquisa1, CDIA1::class.java)
                            intent.putExtras(bundle)
                            Log.d("Pesquisa1", bundle.toString())
                            startActivity(intent)
                        }
                        ads.isChecked -> {
                            bundle.putString("curso", ads.text.toString())
                            bundle.putStringArrayList("infos", recuperaDados())
                            intent = Intent(this@Pesquisa1, ADS1::class.java)
                            intent.putExtras(bundle)
                            Log.d("Pesquisa1", bundle.toString())
                            startActivity(intent)
                        }

                    }
                }
            }
        }

        recepcao.text = recepcaoStr
    }
}
