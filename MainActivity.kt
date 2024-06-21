package net.parisotto.conversor

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextCotacao: EditText = findViewById(R.id.editTextCotacao)
        val editTextDolar: EditText = findViewById(R.id.editTextDolar)
        val textResulado: TextView = findViewById(R.id.textResultado)
        val buttonConverter: Button = findViewById(R.id.buttonConverter)

        buttonConverter.setOnClickListener {
            val valor = editTextCotacao.text.toString().toDouble()
            val dolar = editTextDolar.text.toString().toDouble()
            val convertido = valor * dolar

            textResulado.text = String.format("R$ %.2f", convertido)
        }
    }
}