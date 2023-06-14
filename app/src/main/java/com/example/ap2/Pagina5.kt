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

        button.setOnClickListener {
            val selectedCheckboxes = ArrayList<String>()

            val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)

            for (i in 0 until checkboxContainer.childCount) {
                val checkBox = checkboxContainer.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina5", checkBox.text.toString())
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }

            val previousSelectedCheckboxes = intent.getStringArrayListExtra("selectedCheckboxes")
            if (previousSelectedCheckboxes != null) {
                selectedCheckboxes.addAll(previousSelectedCheckboxes)
            }

            bundle.putString("1", intent.getStringExtra("1"))
            bundle.putString("2", intent.getStringExtra("2"))
            bundle.putStringArrayList("3", intent.getStringArrayListExtra("3"))
            bundle.putStringArrayList("4", selectedCheckboxes)
            bundle.putStringArrayList("infos", recuperaDados())

            val intent = Intent(this@Pagina5, Pagina6::class.java)
            intent.putExtras(bundle)

            Log.d("Pagina5", bundle.toString())
            startActivity(intent)
        }
    }
}
