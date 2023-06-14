package com.example.ap2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class Pagina8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina8)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }

        val respostas = intent.getStringArrayExtra("respostas")

        Log.d("Pagina8", respostas.toString())



    }
}
