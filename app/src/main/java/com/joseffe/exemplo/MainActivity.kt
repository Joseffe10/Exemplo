package com.joseffe.exemplo

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var texto : TextView
    private lateinit var botao : Button
    private lateinit var proximo : Button
    private lateinit var foto : Button
    private lateinit var usuario: ImageView

    //    val boasVindas: String by lazy {
//        val texto = "Seja bem vindo!"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.txtNumero)
        botao = findViewById(R.id.btnSortear)
        proximo = findViewById(R.id.btnProximo)
        foto = findViewById(R.id.btnFoto)
        usuario = findViewById(R.id.fotoUsuario)

        botao.setOnClickListener {
            SortearNumero()
        }

        proximo.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            val usuario = Usuario(nome = "Maria", id = 125)
            intent.putExtra("USUARIO", usuario)
            intent.putExtra("IDADE", 32)
            startActivity(intent)
        }

        foto.setOnClickListener {
            abrirCamera()
        }

        //texto = txtNumero
    }

    fun abrirCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(intent.resolveActivity(packageManager) != null){
            startActivityForResult(intent, 12345)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 12345 && resultCode == RESULT_OK){
            val fotoTirada = data?.extras?.get("data") as Bitmap
            fotoUsuario.setImageBitmap(fotoTirada)
        }
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