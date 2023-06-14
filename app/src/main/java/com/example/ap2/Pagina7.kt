package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class Pagina7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina7)

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
            for (i in 1 until 9) {
                val element = lista?.get(i)
                respostas.add(element.toString())
            }
            return respostas
        }

        button.setOnClickListener {
            val selectedCheckboxes1 = ArrayList<String>()
            val selectedCheckboxes2 = ArrayList<String>()

            for (i in 0 until checkboxContainer1.childCount) {
                val checkBox = checkboxContainer1.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina7", checkBox.text.toString())
                    selectedCheckboxes1.add(checkBox.text.toString())
                }
            }

            for (i in 0 until checkboxContainer2.childCount) {
                val checkBox = checkboxContainer2.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina7", checkBox.text.toString())
                    selectedCheckboxes2.add(checkBox.text.toString())
                }
            }

            bundle.putString("1", intent.getStringExtra("1"))
            bundle.putString("2", intent.getStringExtra("2"))
            bundle.putStringArrayList("3", intent.getStringArrayListExtra("3"))
            bundle.putStringArrayList("4", intent.getStringArrayListExtra("4"))
            bundle.putStringArrayList("5", intent.getStringArrayListExtra("5"))
            bundle.putStringArrayList("6", intent.getStringArrayListExtra("6"))
            bundle.putStringArrayList("7", selectedCheckboxes1)
            bundle.putStringArrayList("8", selectedCheckboxes2)
            bundle.putStringArrayList("infos", recuperaDados())

            val intent = Intent(this@Pagina7, Pagina8::class.java)
            intent.putExtras(bundle)

            Log.d("Pagina7", bundle.toString())
            startActivity(intent)
        }
    }
}
