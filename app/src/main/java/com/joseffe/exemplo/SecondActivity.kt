package com.joseffe.exemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //INTENT EXPLÍCITA
        val idade = intent.extras?.get("IDADE")

        val usuario = intent.extras?.get("USUARIO") as Usuario
        val nomeUsuario = usuario.nome

    }
}