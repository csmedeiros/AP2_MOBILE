
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ap2.Pesquisa3
import com.example.ap2.R

class Pesquisa2 : AppCompatActivity() {

    private var selectedCount = 0
    private lateinit var errorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesquisa2)

        errorMessage = findViewById(R.id.error_message)

        val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)

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

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Verificar se o requisito mínimo de seleção é atendido
            if (selectedCount >= 7) {
                // Navegar para a atividade Pesquisa3
                val intent = Intent(this, Pesquisa3::class.java)
                startActivity(intent)
            } else {
                // Exibir mensagem de erro
                errorMessage.visibility = View.VISIBLE
            }
        }

        // Atualizar o estado inicial do botão
        updateButtonState()
    }

    private fun updateButtonState() {
        val button = findViewById<Button>(R.id.button)
        button.isEnabled = selectedCount >= 7
        errorMessage.visibility = View.GONE
    }
}
