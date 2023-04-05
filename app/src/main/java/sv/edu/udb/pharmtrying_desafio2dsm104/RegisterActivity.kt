package sv.edu.udb.pharmtrying_desafio2dsm104

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    //Auth Firebase
    private lateinit var  auth: FirebaseAuth
    //Componentes Layout
    private lateinit var btnRegister : Button
    private lateinit var btnBack : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        //Importando nuestros botones
        btnRegister = findViewById<Button>(R.id.btnRegister)
        btnBack = findViewById<Button>(R.id.btnBackRegister)

        //Registrar nuevo usuario
        btnRegister.setOnClickListener{
            val email = findViewById<EditText>(R.id.txtEmailRegister).text.toString()
            val pass = findViewById<EditText>(R.id.txtPasswordRegister).text.toString()
            this.registerAcc(email,pass)
        }

        //Solo regresar al Login
        btnBack.setOnClickListener {
            this.openLogin()
        }

    }

    private fun registerAcc(email:String,pass:String){
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish() //Cerramos la conexion a autentica con Firebase
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_SHORT).show()
        }

    }

    private fun openLoginUserExists(){
        val intent = Intent(this, LoginActivity::class.java)
        Toast.makeText(applicationContext, "@string/errorUserExistRegister", Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

    private fun openLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}