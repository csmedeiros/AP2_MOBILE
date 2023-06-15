package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class Pagina2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina2)

        val bundle = Bundle()
        val maisDeUmaVez = findViewById<RadioButton>(R.id.rbMaisDeUmaVez)
        val umaVez = findViewById<RadioButton>(R.id.rbUmaVez)
        val nunca = findViewById<RadioButton>(R.id.rbNunca)
        val groupCursos = findViewById<RadioGroup>(R.id.rgCursos)
        val prox = findViewById<Button>(R.id.btnProx)

        // Variável para armazenar a opção selecionada
        var opcaoSelecionada: String? = null

        groupCursos.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId > 0) {
                Log.d("Pagina2", checkedId.toString())

                // Armazenar a opção selecionada na variável
                opcaoSelecionada = when (checkedId) {
                    maisDeUmaVez.id -> maisDeUmaVez.text.toString()
                    umaVez.id -> umaVez.text.toString()
                    nunca.id -> nunca.text.toString()
                    else -> null
                }

                // Desmarcar as outras opções
                if (checkedId != maisDeUmaVez.id) {
                    maisDeUmaVez.isChecked = false
                }
                if (checkedId != umaVez.id) {
                    umaVez.isChecked = false
                }
                if (checkedId != nunca.id) {
                    nunca.isChecked = false
                }
            }
        }

        prox.setOnClickListener {
            val intent = Intent(this@Pagina2, Pagina3::class.java)
            bundle.putString("1", opcaoSelecionada)
            intent.putExtras(bundle)
            Log.d("Pagina2", "Pagina2")
            Log.d("Pagina2", bundle.toString())
            startActivity(intent)
        }
    }
}
