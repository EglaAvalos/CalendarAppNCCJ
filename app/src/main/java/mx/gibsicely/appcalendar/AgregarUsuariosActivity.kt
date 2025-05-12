package mx.gibsicely.appcalendar

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgregarUsuariosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_usuario)

        val etNombre = findViewById<EditText>(R.id.etNombreUsuario)
        val etContrasena = findViewById<EditText>(R.id.etContrasenaUsuario)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarUsuario)
        val spEsAdmin = findViewById<Spinner>(R.id.spinnerEsAdmin)

        val userRepository = UserRepository(this)

        // Configuramos el spinner para elegir si es admin (1) o no (0)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.admin_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spEsAdmin.adapter = adapter

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val contrasena = etContrasena.text.toString()
            val esAdmin = if (spEsAdmin.selectedItemPosition == 0) 1 else 0 // Si es admin, valor 1

            if (nombre.isNotEmpty() && contrasena.isNotEmpty()) {
                // Ahora recibe el valor retornado por insertUser
                val result = userRepository.insertUser(nombre, contrasena, esAdmin)
                if (result != -1L) {
                    Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Error al guardar usuario", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
