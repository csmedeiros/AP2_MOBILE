package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class Pagina4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina4)

        val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)
        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }



        button.setOnClickListener {
            // Passar nome, idade e matrícula para o bundle
            intent.putStringArrayListExtra("infos", recuperaDados())

            // Criar uma lista para armazenar as checkboxes selecionadas
            val selectedCheckboxes = ArrayList<String>()

            val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)

            // Percorrer todas as checkboxes e adicionar as selecionadas à lista
            for (i in 0 until checkboxContainer.childCount) {
                val checkBox = checkboxContainer.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina4", checkBox.text.toString())
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }

            // Passar a lista para a próxima atividade
            val intent = Intent(this@Pagina4, Pagina5::class.java)
            Log.d("Pesquisa4", "Obtendo 1 e 2")
            for(i in 1 until 3) {
                val resposta = intent.getStringExtra("$i")
                bundle.putString("$i", resposta)
            }
            bundle.putStringArrayList("infos", recuperaDados())
            Log.d("Pesquisa4", "infos adicionada")
            intent.putExtras(bundle)
            Log.d("Pagina4", "Pagina4")
            Log.d("Pagina4", bundle.toString())
            startActivity(intent)
        }
    }
}
