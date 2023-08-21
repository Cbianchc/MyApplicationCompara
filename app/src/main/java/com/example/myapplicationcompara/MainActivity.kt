package com.example.myapplicationcompara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import model.TextComparar
import viewmodel.viewmodel.TextComparaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TextComparaViewModel

    private lateinit var inputPrimero: EditText
    private lateinit var inputSegundo: EditText
    private lateinit var btnLanzar: Button
    private lateinit var textFinal: TextView
    private lateinit var Reiniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TextComparaViewModel::class.java)

        inputPrimero = findViewById(R.id.inputTextPrimero)
        inputSegundo = findViewById(R.id.inputTextSegundo)
        btnLanzar = findViewById(R.id.btnCompara)
        textFinal = findViewById(R.id.txtRespuesta)
        Reiniciar = findViewById(R.id.btnRestart)


        btnLanzar.setOnClickListener {
            val textComparison = TextComparar(inputPrimero.text.toString(), inputSegundo.text.toString())

            if (viewModel.compareTexts(textComparison)) {
                textFinal.text = "Los textos son iguales"

                //Toast.makeText(this, "Los texos son iguales", Toast.LENGTH_LONG).show()
            } else {
                textFinal.text = "Los textos NO SON IGUALES"
                //Toast.makeText(this, "Los texos NO son iguales", Toast.LENGTH_LONG).show()
            }
        }

        Reiniciar.setOnClickListener {
            inputPrimero.text.clear()
            inputSegundo.text.clear()
            textFinal.text = ""
        }
    }
}
