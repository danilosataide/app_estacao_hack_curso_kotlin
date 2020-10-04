package br.com.danilosataide.estaohackcurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    // fun onCreate é um dos métodos presentes no ciclo de vida da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Abrindo a LoginActivity após 5 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //Iniciar a tela de Login
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 5000)


    }
}