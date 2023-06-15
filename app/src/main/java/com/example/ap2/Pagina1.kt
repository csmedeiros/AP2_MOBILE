package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button

class Pagina1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagina1)

        val pesquisa = findViewById<Button>(R.id.btnPesquisa)

        val fragment = DialFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()

        pesquisa.setOnClickListener {
                val intent = Intent(this@Pagina1, Pagina2::class.java)
                Log.d("Pagina1", "Pagina1")
                Log.d("Pagina1", intent.extras.toString())
                startActivity(intent)
            }
        }
    }
