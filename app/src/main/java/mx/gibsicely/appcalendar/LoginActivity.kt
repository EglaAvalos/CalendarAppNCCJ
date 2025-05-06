package mx.gibsicely.appcalendar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)

        btnIniciarSesion.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val contrasena = etContrasena.text.toString()

            // Validación básica de usuario y contraseña
            if (usuario == "admin" && contrasena == "admin") {
                // Si el usuario es "admin" y la contraseña es "admin", navega al calendario
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent)
                finish()
            } else if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                // Si los campos no están vacíos pero el usuario es incorrecto
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            } else {
                // Si alguno de los campos está vacío
                Toast.makeText(this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
