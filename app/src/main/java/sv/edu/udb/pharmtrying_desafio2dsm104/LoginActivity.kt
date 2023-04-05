package sv.edu.udb.pharmtrying_desafio2dsm104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    //Auth Firebase
    private lateinit var auth: FirebaseAuth

    //Componentes Layout (Botones)
    private lateinit var btnLogin : Button
    private lateinit var btnExitLogin : Button
    private lateinit var btnlbRegisterLogin : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        //Importando nuestro botones
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnExitLogin = findViewById<Button>(R.id.btnExit)
        val btnlbRegisterLogin = findViewById<TextView>(R.id.btnlbRegister)

        //Cerrando la aplicacion
        btnExitLogin.setOnClickListener {
            Toast.makeText(this, "Cerrar Aplicacion", Toast.LENGTH_SHORT).show()
            this.closeApp()
        }

        //Abriendo la pantalla de Registrar Usuario
        btnlbRegisterLogin.setOnClickListener {
            Toast.makeText(this, "Abrir Registrar Cuenta", Toast.LENGTH_SHORT).show()
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