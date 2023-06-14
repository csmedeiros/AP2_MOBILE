package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout

class ADS2 : AppCompatActivity() {
    private var selectedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ads2)

        val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)
        val bundle = Bundle()

        // Adicione listeners para as CheckBox
        for (i in 0 until checkboxContainer.childCount) {
            val checkBox = checkboxContainer.getChildAt(i) as CheckBox
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedCount++
                } else {
                    selectedCount--
                }
                updateButtonState()
            }
        }

        val button = findViewById<Button>(R.id.btnProx)

        button.setOnClickListener {
            // Verificar se o requisito mínimo de seleção é atendido
            if (selectedCount >= 1) {
                // Criar uma lista para armazenar as checkboxes selecionadas
                val selectedCheckboxes = ArrayList<String>()

                val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)

                // Percorrer todas as checkboxes e adicionar as selecionadas à lista
                for (i in 0 until checkboxContainer.childCount) {
                    val checkBox = checkboxContainer.getChildAt(i) as CheckBox
                    if (checkBox.isChecked) {
                        Log.d("ADS2", checkBox.text.toString())
                        selectedCheckboxes.add(checkBox.text.toString())
                    }
                }

                fun recuperaDados(): java.util.ArrayList<String>? {
                    val infos = intent.getStringArrayListExtra("infos")
                    return infos
                }

                // Passar a lista para a próxima atividade
                val intent = Intent(this@ADS2, ADS3::class.java)

                // Recuperar a lista da Activity anterior (EngComp3)
                val previousSelectedCheckboxes = intent.getStringArrayListExtra("selectedCheckboxes")
                if (previousSelectedCheckboxes != null) {
                    selectedCheckboxes.addAll(previousSelectedCheckboxes)
                }

                // Passar a lista e os dados extras para a próxima atividade
                bundle.putStringArrayList("selectedCheckboxes", selectedCheckboxes)
                bundle.putStringArrayList("infos", recuperaDados())
                intent.putExtras(bundle)

                Log.d("ADS2", bundle.toString())
                startActivity(intent)
            }
        }

        // Atualizar o estado inicial do botão
        updateButtonState()
    }

    private fun updateButtonState() {
        val button = findViewById<Button>(R.id.btnProx)
        button.isEnabled = selectedCount >= 1
    }
}
