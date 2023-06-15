package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.RadioButton

class Pagina5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina5)

        val checkboxSimDf = findViewById<RadioButton>(R.id.checkbox_sim_df)
        val checkboxSimForaDf = findViewById<RadioButton>(R.id.checkbox_sim_fora_df)
        val checkboxNao = findViewById<RadioButton>(R.id.checkbox_nao)
        val button = findViewById<Button>(R.id.btnProx)

        val bundle = Bundle()

        button.setOnClickListener {
            var selectedCheckboxes:String

            if (checkboxSimDf.isChecked) {
                selectedCheckboxes = checkboxSimDf.text.toString()
                bundle.putString("4", selectedCheckboxes)
            }

            if (checkboxSimForaDf.isChecked) {
                selectedCheckboxes = checkboxSimForaDf.text.toString()
                bundle.putString("4", selectedCheckboxes)
            }

            if (checkboxNao.isChecked) {
                selectedCheckboxes = checkboxNao.text.toString()
                bundle.putString("4", selectedCheckboxes)
            }

            bundle.putString("1", intent.getStringExtra("1"))
            bundle.putStringArrayList("2", intent.getStringArrayListExtra("2"))
            bundle.putStringArrayList("3", intent.getStringArrayListExtra("3"))

            val intent = Intent(this@Pagina5, Pagina6::class.java)
            intent.putExtras(bundle)

            Log.d("Pagina5", "Pagina5")
            Log.d("Pagina5", bundle.toString())
            startActivity(intent)
        }
    }
}
