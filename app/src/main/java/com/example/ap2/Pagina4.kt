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

        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        button.setOnClickListener {
            val selectedCheckboxes = ArrayList<String>()

            val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)

            for (i in 0 until checkboxContainer.childCount) {
                val checkBox = checkboxContainer.getChildAt(i) as CheckBox
                if (checkBox.isChecked) {
                    Log.d("Pagina4", checkBox.text.toString())
                    selectedCheckboxes.add(checkBox.text.toString())
                }
            }
            if(selectedCheckboxes.count()>0) {
                bundle.putStringArrayList("3", selectedCheckboxes)
            }
            else {
                selectedCheckboxes.add("NULL")
                bundle.putStringArrayList("3", selectedCheckboxes)
            }

            val resposta1 = intent.getStringExtra("1")
            val resposta2 = intent.getStringArrayListExtra("2")

            bundle.putString("1", resposta1)
            bundle.putStringArrayList("2", resposta2)

            val intent = Intent(this@Pagina4, Pagina5::class.java)
            intent.putExtras(bundle)
            Log.d("Pagina4", "Pagina4")
            Log.d("Pagina4", bundle.toString())
            startActivity(intent)
        }
    }
}
