package com.example.ap2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Pesquisa2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesquisa2)

        val curso = intent.getStringExtra("curso")

    }
}
