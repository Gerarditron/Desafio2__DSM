package sv.edu.udb.pharmtrying_desafio2dsm104

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    //Auth Firebase
    lateinit var auth: FirebaseAuth

    //Componentes Layout (Botones)
    lateinit var btnLogin : Button
    lateinit var btnExitLogin : Button
    lateinit var btnlbRegisterLogin : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        //Importando nuestro botones
        btnLogin = findViewById(R.id.btnLogin)
        btnExitLogin = findViewById(R.id.btnExit)
        btnlbRegisterLogin = findViewById(R.id.btnlbRegister)



        //Cerrando la aplicacion
        btnExitLogin.setOnClickListener{
            this.closeApp()
        }

        //Abriendo la pantalla de Registrar Usuario
        btnlbRegisterLogin.setOnClickListener {
            this.openRegisterAcc()
        }


    }

    private fun openRegisterAcc(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun closeApp(){
        exitProcess(-1)
    }

}