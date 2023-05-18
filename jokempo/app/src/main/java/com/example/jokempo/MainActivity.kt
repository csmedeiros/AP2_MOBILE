package com.example.jokempo

import android.graphics.Color
import android.media.Image
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pedra = findViewById<ImageButton>(R.id.btnPedra)
        val papel = findViewById<ImageButton>(R.id.btnPapel)
        val tesoura = findViewById<ImageButton>(R.id.btnTesoura)
        val iPedra = findViewById<ImageView>(R.id.ivPedra)
        iPedra.visibility = View.INVISIBLE
        val iPapel = findViewById<ImageView>(R.id.ivPapel)
        iPapel.visibility = View.INVISIBLE
        val iTesoura = findViewById<ImageView>(R.id.ivTesoura)
        iTesoura.visibility = View.INVISIBLE
        val resultado = findViewById<TextView>(R.id.tvResultado)

        fun jogada(n:Int) {
            val m = Random.nextInt(1, 4)
            Log.d("MainActivity", m.toString())
            when (m) {
                1 -> {
                    iPedra.visibility = VISIBLE
                    iPapel.visibility = View.INVISIBLE
                    iTesoura.visibility = View.INVISIBLE
                }
                2 -> {
                    iPapel.visibility = VISIBLE
                    iPedra.visibility = View.INVISIBLE
                    iTesoura.visibility = View.INVISIBLE
                }
                3 -> {
                    iTesoura.visibility = VISIBLE
                    iPapel.visibility = View.INVISIBLE
                    iPedra.visibility = View.INVISIBLE
                }
            }
            if(m==n) {
                resultado.setTextColor(Color.GRAY)
                resultado.text = "EMPATE"
            }
            else if(n==2 && m==1) {
                resultado.setTextColor(Color.GREEN)
                resultado.text = "VITORIA"
            }
            else if(n==3 && m==2) {
                resultado.setTextColor(Color.GREEN)
                resultado.text = "VITORIA"
            }
            else if(n==1 && m==3) {
                resultado.setTextColor(Color.GREEN)
                resultado.text = "VITORIA"
            }
            else if(n==1 && m==2) {
                resultado.setTextColor(Color.RED)
                resultado.text = "DERROTA"
            }
            else if(n==2 && m==3) {
                resultado.setTextColor(Color.RED)
                resultado.text = "DERROTA"
            }
            else if(n==3 && m==1) {
                resultado.setTextColor(Color.RED)
                resultado.text = "DERROTA"
            }
        }

        pedra.setOnClickListener() {
            val n:Int = 1
            jogada(n)
        }
        papel.setOnClickListener() {
            val n:Int = 2
            jogada(n)
        }
        tesoura.setOnClickListener() {
            val n:Int = 3
            jogada(n)
        }

    }
}