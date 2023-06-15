package com.example.ap2

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

class Pagina8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina8)

        val q1 = intent.getStringExtra("1")
        val q2 = intent.getStringArrayListExtra("2")
        val q3 = intent.getStringArrayListExtra("3")
        val q4 = intent.getStringExtra("4")
        val q5 = intent.getStringExtra("5")
        val q6 = intent.getStringExtra("6")
        val q7 = intent.getStringExtra("7")
        val q8 = intent.getStringExtra("8")
        val resultado = findViewById<TextView>(R.id.tvResultado)
        resultado.setTextColor(Color.RED)

        val fragment = DialFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
        if (!q1.contentEquals("Nunca") ||
            !q2.toString().contentEquals("[NULL]") ||
            (!q3.toString().contentEquals("[NULL]") && (
                    "O autor disse algo parecido com a frase: “se não for minha, não será de mais ninguém" in q3.toString() ||
                            "O autor te perturba, persegue ou vigia nos locais em que você frequenta" in q3.toString() ||
                            "O autor proíbe você de ir ao médico ou pedir ajuda a outros profissionais" in q3.toString()))
        ) {
            Log.d("Pagina8", "Risco extremo unanime")
            resultado.setText("PROVÁVEL RISCO EXTREMO!\nSituação de iminente violência física grave ou possivelmente letal.\nAcompanhamento próximo da Policia Civil deverá imediatamente solicitado\n Recomendamos que ligue para a Polícia Civil")
        }


        else {
            var qcount: Int = 0
            qcount += q3?.size ?: 0
            if (!q4.contentEquals("Não")) {
                qcount += 1
                Log.d("Pagina8", "+1")
            }
            if (!q5.contentEquals("Nunca")) {
                qcount += 1
                Log.d("Pagina8", "+1")
            }
            if (!q6.contentEquals("Nunca")) {
                qcount += 1
                Log.d("Pagina8", "+1")
            }
            if (!q7.contentEquals("Não")) {
                qcount += 1
                Log.d("Pagina8", "+1")
            }
            if (!q8.contentEquals("Nunca")) {
                qcount += 1
            }

            Log.d("Pagina8", qcount.toString())

            if (qcount >= 8) {
                resultado.setText("PROVÁVEL RISCO EXTREMO!\nSituação de iminente violência física grave ou possivelmente letal.\nAcompanhamento próximo da Polícia Civil deverá imediatamente solicitado\nRecomendamos que ligue para a Polícia Civil")
            } else if (qcount in 5..7) {
                resultado.setText("PROVÁVEL RISCO GRAVE!\nSituação de violências sérias, mas sem risco de violência física grave\nou com potencial para chegar em risco extremo.\nJustifica as intervenções cabíveis de proteção à vítima e o monitoramento da evolução da\nsituação de violência\nRecomendamos que ligue para a Polícia Civil")
            } else {
                resultado.setText("PROVÁVEL RISCO MODERADO!\nSituação atual de violências sérias sem indicadores de\nrisco iminente de violências físicas graves ou potencialmente letais,\na justificar a tramitação ordinária do processo\nRecomendamos que ligue para a Polícia Civil")
            }

            Log.d("Pagina8", "Pagina8")
            Log.d("Pagina8", "$q1, $q2, $q3, $q4, $q5, $q6, $q7")
        }
    }
}
