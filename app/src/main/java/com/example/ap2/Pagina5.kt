package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class Pagina5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina5)

        val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)
        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }

        fun recuperaRespostas(): ArrayList<String> {
            val respostas = ArrayList<String>()
            val lista = intent.getStringArrayExtra("1a2")
            for(i in 1 until 4) {
                val element = lista?.get(i)
                respostas.add(element.toString())
            }
            return respostas
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
                    Log.d("Pagina5", checkBox.text.toString())
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }

            // Recuperar a lista da Activity anterior
            val previousSelectedCheckboxes = intent.getStringArrayListExtra("selectedCheckboxes")
            if (previousSelectedCheckboxes != null) {
                selectedCheckboxes.addAll(previousSelectedCheckboxes)
            }

            // Passar a lista para a próxima atividade
            val intent = Intent(this@Pagina5, Pagina8::class.java)
            val respostas = recuperaRespostas()
            respostas.add(selectedCheckboxes.toString())
            bundle.putStringArrayList("1a4", respostas)
            bundle.putStringArrayList("infos", recuperaDados())
            intent.putExtras(bundle)

            Log.d("Pagina5", bundle.toString())
            startActivity(intent)
        }
    }
}
