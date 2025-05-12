package mx.gibsicely.appcalendar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)

        val btnEventos = findViewById<Button>(R.id.btnEventos)
        val btnMisionValores = findViewById<Button>(R.id.btnMisionValores)
        val btnAgregarUsuario = findViewById<Button>(R.id.btnAgregarUsuario)

        btnEventos.setOnClickListener {
            val intent = Intent(this, EditEventosActivity::class.java)
            startActivity(intent)
        }

        btnMisionValores.setOnClickListener {
            val intent = Intent(this, EditMisionValoresActivity::class.java)
            startActivity(intent)
        }

        btnAgregarUsuario.setOnClickListener {
            val intent = Intent(this, AgregarUsuariosActivity::class.java)
            startActivity(intent)
        }
    }
}
