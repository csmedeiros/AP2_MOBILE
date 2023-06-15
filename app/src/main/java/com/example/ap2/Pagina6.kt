package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton

class Pagina6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina6)
        val umaVez = findViewById<RadioButton>(R.id.checkbox_uma_vez)
        val maisDeUmaVez = findViewById<RadioButton>(R.id.checkbox_mais_uma_vez)
        val nunca = findViewById<RadioButton>(R.id.checkbox_nunca)
        val umaVez2 = findViewById<RadioButton>(R.id.checkbox_uma_vez2)
        val maisDeUmaVez2 = findViewById<RadioButton>(R.id.checkbox_mais_uma_vez2)
        val nunca2 = findViewById<RadioButton>(R.id.checkbox_nunca2)
        val checkboxContainer2 = findViewById<LinearLayout>(R.id.checkbox_container2)
        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }

        button.setOnClickListener {
            button.setOnClickListener {
                var selectedCheckboxes: String

                if (umaVez.isChecked) {
                    selectedCheckboxes = umaVez.text.toString()
                    bundle.putString("4", selectedCheckboxes)
                }

                if (maisDeUmaVez.isChecked) {
                    selectedCheckboxes = maisDeUmaVez.text.toString()
                    bundle.putString("4", selectedCheckboxes)
                }

                if (nunca.isChecked) {
                    selectedCheckboxes = nunca.text.toString()
                    bundle.putString("4", selectedCheckboxes)
                }




                if (umaVez2.isChecked) {
                    bundle.putString("5", umaVez2.text.toString())
                }

                if (maisDeUmaVez2.isChecked) {
                    bundle.putString("5", maisDeUmaVez2.toString())
                }

                if (nunca2.isChecked) {
                    bundle.putString("5", nunca2.text.toString())
                }

                bundle.putString("1", intent.getStringExtra("1"))
                bundle.putString("2", intent.getStringExtra("2"))
                bundle.putStringArrayList("3", intent.getStringArrayListExtra("3"))
                bundle.putString("4", intent.getStringExtra("4"))


                bundle.putStringArrayList("infos", recuperaDados())

                val intent = Intent(this@Pagina6, Pagina7::class.java)
                intent.putExtras(bundle)
                Log.d("Pagina6", "Pagina6")
                Log.d("Pagina6", bundle.toString())
                startActivity(intent)
            }
        }
    }
}