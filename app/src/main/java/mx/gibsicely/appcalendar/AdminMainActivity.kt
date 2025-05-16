package mx.gibsicely.appcalendar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)

        val btnMain = findViewById<Button>(R.id.btnMain)
        val btnAgregarUsuario = findViewById<Button>(R.id.btnAgregarUsuario)

        btnMain.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }

        btnAgregarUsuario.setOnClickListener {
            val intent = Intent(this, AgregarUsuariosActivity::class.java)
            startActivity(intent)
        }
    }
}
