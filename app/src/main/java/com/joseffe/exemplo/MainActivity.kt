package com.joseffe.exemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.txtNumero
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var texto : TextView
    private lateinit var botao : Button

    //    val boasVindas: String by lazy {
//        val texto = "Seja bem vindo!"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.txtNumero)
        botao = findViewById(R.id.btnSortear)

        botao.setOnClickListener {
            SortearNumero()
        }

        //texto = txtNumero
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onStart() {
        super.onStart()
        Log.d("CICLOVIDA", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CICLOVIDA", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CICLOVIDA", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CICLOVIDA", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLOVIDA", "OnDestroy")
    }

    fun SortearNumero(){
        val numeroSorteado = Random().nextInt(11)

        texto.text = "O número é: $numeroSorteado"

        Log.d("NUMERO", texto.text.toString())
    }
}