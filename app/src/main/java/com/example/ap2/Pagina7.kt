package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton

class Pagina7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina7)

        val umaVez = findViewById<RadioButton>(R.id.checkbox_uma_vez)
        val maisDeUmaVez = findViewById<RadioButton>(R.id.checkbox_mais_uma_vez)
        val nunca = findViewById<RadioButton>(R.id.checkbox_nunca)
        val sim = findViewById<RadioButton>(R.id.checkbox_sim)
        val nao = findViewById<RadioButton>(R.id.checkbox_nao)
        val checkboxContainer1 = findViewById<LinearLayout>(R.id.checkbox_container)

        val bundle = Bundle()

        val button = findViewById<Button>(R.id.btnProx)

        button.setOnClickListener {

            if (sim.isChecked) {
                bundle.putString("7", sim.text.toString())
            }

            if(nao.isChecked) {
                bundle.putString("7", nao.text.toString())
            }

            if (umaVez.isChecked) {
                bundle.putString("8", umaVez.text.toString())
            }

            if (maisDeUmaVez.isChecked) {
                bundle.putString("8", maisDeUmaVez.text.toString())
            }

            if (nunca.isChecked) {
                bundle.putString("8", nunca.text.toString())
            }



            bundle.putString("1", intent.getStringExtra("1"))
            bundle.putStringArrayList("2", intent.getStringArrayListExtra("2"))
            bundle.putStringArrayList("3", intent.getStringArrayListExtra("3"))
            bundle.putString("4", intent.getStringExtra("4"))
            bundle.putString("5", intent.getStringExtra("5"))
            bundle.putString("6", intent.getStringExtra("6"))

            val intent = Intent(this@Pagina7, Pagina8::class.java)
            intent.putExtras(bundle)

            Log.d("Pagina7", "Pagina7")
            Log.d("Pagina7", bundle.toString())
            startActivity(intent)
        }
    }
}
