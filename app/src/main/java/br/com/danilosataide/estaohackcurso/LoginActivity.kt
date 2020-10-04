package br.com.danilosataide.estaohackcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executando o clique do botão entrar
        btnLoginEntrar.setOnClickListener {

            //Capturar dados digitados pelo usuário
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            //Validação dos campos
            if(email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório!"
                edtLoginEmail.requestFocus()
            } else if(senha.isEmpty()){
                edtLoginSenha.error = "Campo obrigatório!"
                edtLoginSenha.requestFocus()
            } else {
                //Verificar se os dados digitados são iguais aos dados cadastrados no Shared Preferences
                //Acessando o arquivo de preferencias compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                //Recuperando os dados no arquivo shared preferences
                val emailPrefs = sharedPrefs.getString("EMAIL", "Chave não encontrada")
                val senhaPrefs = sharedPrefs.getString("SENHA", "Chave não encontrada")

                //Verificando email e senha
                if(email == emailPrefs && senha == senhaPrefs) {

                    Toast.makeText(this, "Usuário logado com sucesso!",Toast.LENGTH_LONG).show()
                    //Abrindo a MainActivity
                    val mIntent = Intent(this, MainActivity::class.java)
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                } else {
                    //Apresentar uma mensagem ao usuário
                    Toast.makeText(this, "E-mail ou senha inválidos!",Toast.LENGTH_LONG).show()
                }

            }
        }

        // Executando o clique do botão cadastrar
        btnLoginCadastrar.setOnClickListener {
            // Abrindo a tela do cadastro
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }
    }
}