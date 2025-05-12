package mx.gibsicely.appcalendar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Acceder a los elementos de la interfaz
        val btnLeaders = findViewById<Button>(R.id.btn_leaders)
        val btnMission = findViewById<Button>(R.id.btn_mission)
        val btnHelp = findViewById<Button>(R.id.btn_help)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        // Evento para el botón de Líderes
        btnLeaders.setOnClickListener {
            // Navegar a la actividad de Líderes (ajustar si la actividad se llama diferente)
            startActivity(Intent(this, LeaderListActivity::class.java))
        }

        // Evento para el botón de Misión y Valores
        btnMission.setOnClickListener {
            // Navegar a la actividad de Misión y Valores
            startActivity(Intent(this, MisionValorActivity::class.java))
        }

        // Evento para el botón de Centro de Ayuda
        btnHelp.setOnClickListener {
            // Navegar a la actividad de Centro de Ayuda
            startActivity(Intent(this, HelpCenterActivity::class.java))
        }

        // Evento para el botón de Cerrar Sesión
        btnCerrarSesion.setOnClickListener {
            // Volver a la actividad de login, limpiando el stack
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
