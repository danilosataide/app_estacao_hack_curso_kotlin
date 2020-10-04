package br.com.danilosataide.estaohackcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperando o email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //Acessar o arquivo de preferências compartilhadas
        val sharedPrefs = getSharedPreferences(
            "cadastro_$email",
            Context.MODE_PRIVATE
        )

        //Recuperar dados no arquivo de preferencias compartilhadas
        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "")

        //Exibir os dados recuperados na tela
        txvMainNome.text = "$nome $sobrenome"
        txvMainEmail.text = "$email"
        txvMainGenero.text = "$genero"

        //Escutando o clique do botão Sair
        btnMainSair.setOnClickListener {
            // Criando uma caixa de diálogo
            val alert = AlertDialog.Builder(this)

            //Definindo o título da caixa de diálogo
            alert.setTitle("App Curso Estação Hack")

            //Definindo o corpo da mensagem
            alert.setMessage("Deseja sair do aplicativo?")

            //Definindo o rótulo do botão e escutando o clique
            alert.setPositiveButton("Sair") {dialog, wich ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                //Eliminando as telas da pilha
                finishAffinity()
            }

            //Definindo o rótulo do botão e escutando seu clique
            alert.setNegativeButton("Não") {_,_ ->}

            //Exibindo a caixa de diálogo
            alert.show()
        }

        btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }
}