package com.example.ap2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class Pagina8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina8)


        val q1 = intent.getStringExtra("1")
        val q2 = intent.getStringExtra("2")
        val q3 = intent.getStringArrayListExtra("3")
        val q4 = intent.getStringExtra("4")
        val q5 = intent.getStringArrayListExtra("5")
        val q6 = intent.getStringExtra("6")
        val q7 = intent.getStringArrayListExtra("7")
        val infos = intent.getStringArrayListExtra("infos")

        Log.d("Pagina8", "Pagina8")
        Log.d("Pagina8", "$q1, $q2, $q3, $q4, $q5, $q6, $q7, $infos")
    }
}
