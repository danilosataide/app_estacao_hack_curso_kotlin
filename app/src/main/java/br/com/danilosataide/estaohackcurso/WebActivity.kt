package br.com.danilosataide.estaohackcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Habilitando a execução de códigos Java
        wbvSite.settings.javaScriptEnabled = true;

        //Carregando um endereço Web
        wbvSite.loadUrl("http://br.cellep.com/estacaohack/")

        //Definindo o cliente Web padrão
        wbvSite.webViewClient = WebViewClient()
    }
}