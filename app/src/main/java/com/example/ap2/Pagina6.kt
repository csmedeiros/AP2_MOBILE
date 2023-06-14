package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class Pagina6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina6)

        val checkboxContainer1 = findViewById<LinearLayout>(R.id.checkbox_container)
        val checkboxContainer2 = findViewById<LinearLayout>(R.id.checkbox_container2)
        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }

        fun recuperaRespostas(): ArrayList<String> {
            val respostas = ArrayList<String>()
            val lista = intent.getStringArrayExtra("1a2")
            for(i in 1 until 5) {
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
            val selectedCheckboxes2 = ArrayList<String>()

            // Percorrer as checkboxes do primeiro container
            for (i in 0 until checkboxContainer1.childCount) {
                val checkBox = checkboxContainer1.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina6", checkBox.text.toString())
                    Log.d("Pagina6", recuperaDados().toString())
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }

            // Percorrer as checkboxes do segundo container
            for (i in 0 until checkboxContainer2.childCount) {
                val checkBox = checkboxContainer2.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina6", checkBox.text.toString())
                    Log.d("Pagina6", recuperaDados().toString())
                    selectedCheckboxes2.add(checkBox.text.toString())
                }
            }

            // Passar a lista para a próxima atividade
            val intent = Intent(this@Pagina6, Pagina7::class.java)
            val respostas = recuperaRespostas()
            respostas.add(selectedCheckboxes.toString())
            respostas.add(selectedCheckboxes2.toString())
            bundle.putStringArrayList("1a6", respostas)
            bundle.putStringArrayList("infos", recuperaDados())
            intent.putExtras(bundle)

            Log.d("Pagina6", bundle.toString())
            startActivity(intent)
        }
    }
}
