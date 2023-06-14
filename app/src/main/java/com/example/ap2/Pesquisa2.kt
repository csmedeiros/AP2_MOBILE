package com.example.ap2

import ChatGPTIntegration
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

class Pesquisa2 : AppCompatActivity() {
    private val gpt = ChatGPTIntegration()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesquisa2)

        fun recuperaDados(): ArrayList<String>? {
            val infos = intent.getStringArrayListExtra("infos")
            return infos
        }

        fun recuperaDisciplinas(): Array<out String>? {
            val disciplinas = intent.getStringArrayExtra("selectedCheckboxes")
            return disciplinas
        }

        Log.d("Pesquisa2", recuperaDisciplinas().toString())

        val chatGPTIntegration = ChatGPTIntegration()
        val apiKey = "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"
        val message = "Para um aluno de Engenharia da Computação, quais as profissões na área de tecnologia mais adequadas para ele trabalhar considerando que as disciplinas que ele gosta são:" + recuperaDisciplinas()?.joinToString(", ") + "\n\nFormula as respostas, restringindo-se as disciplinas fornecidas e com profissões diferenciadas. A formatação da sua resposta deve ser:\nAqui estão algumas profissões em que você utilizará os conceitos das disciplinas que selecionou:\n<Profissões>\nO CASA e Carreiras Ibmec agradece a sua participação. Insira abaixo seu e-mail para enviarmos o resultado desse teste."

        val response = chatGPTIntegration.sendMessage(message, apiKey)
        if (response != null) {
            // Faça algo com a resposta gerada pelo ChatGPT
            println(response)
        } else {
            // Trate o caso em que nenhuma resposta foi gerada ou ocorreu um erro
            println("Erro ao obter resultado da pesquisa.\nVerifique sua conexão com a Internet ou tente novamente mais tarde.")
        }

        val interacao = findViewById<TextView>(R.id.tvInteracao)
        val textoInteracao = "Muito bem, ${recuperaDados()?.get(0)}!\nDe acordo com as disciplinas selecionadas e seus conteúdos, selecionamos algumas profissões.\n\n$response"
        interacao.text = textoInteracao
        interacao.setTextColor(Color.GREEN)
    }
}
