package sv.edu.udb.pharmtrying_desafio2dsm104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    //Auth Firebase
    private lateinit var auth: FirebaseAuth

    //Componentes Layout (Botones)
    private lateinit var btnLogin : Button
    private lateinit var btnlbRegisterLogin : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        //Importando nuestro botones
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnlbRegisterLogin = findViewById<TextView>(R.id.btnlbRegister)

        btnLogin.setOnClickListener {
            val email = findViewById<EditText>(R.id.txtEmailLogin).text.toString()
            val pass = findViewById<EditText>(R.id.txtPasswordLogin).text.toString()
            this.login(email,pass)
        }

        //Abriendo la pantalla de Registrar Usuario
        btnlbRegisterLogin.setOnClickListener {
            this.openRegisterAcc()
        }

    }

    private fun login(email:String, pass:String){
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener { task->
            if(task.isSuccessful){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() //Cerrando el autorizador
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_SHORT).show()
        }

    }

    private fun openRegisterAcc(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

}