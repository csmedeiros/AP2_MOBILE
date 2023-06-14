package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class Pagina3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina3)

        val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)
        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }

        button.setOnClickListener {
            // Criar uma lista para armazenar as checkboxes selecionadas
            val selectedCheckboxes = ArrayList<String>()

            val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)

            // Percorrer todas as checkboxes e adicionar as selecionadas à lista
            for (i in 0 until checkboxContainer.childCount) {
                val checkBox = checkboxContainer.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("EngComp1", checkBox.text.toString())
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }

            // Passar a lista para a próxima atividade
            val resposta1 = intent.getStringExtra("1")
            bundle.putString("1", resposta1.toString())
            bundle.putString("2", selectedCheckboxes.toString())
            Log.d("Pagina3", "adicionou 1 e 2")
            bundle.putStringArrayList("infos", recuperaDados())
            val intent = Intent(this@Pagina3, Pagina4::class.java)
            intent.putExtras(bundle)
            Log.d("Pagina3", "Pagina3")
            Log.d("Pagina3", bundle.toString())
            startActivity(intent)
        }
    }
}
