package sv.edu.udb.pharmtrying_desafio2dsm104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val opc = item.itemId
        if(opc == R.id.opc1){
            val intent = Intent(this,BuyActivity::class.java)
            startActivity(intent)
        }
        if(opc == R.id.opc2){
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
        if(opc == R.id.opc3){
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}