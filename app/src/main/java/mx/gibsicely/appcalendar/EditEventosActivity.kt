package mx.gibsicely.appcalendar

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EditEventosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_eventos)

        val etTitulo = findViewById<EditText>(R.id.etTituloEvento)
        val etFecha = findViewById<EditText>(R.id.etFechaEvento)
        val etDescripcion = findViewById<EditText>(R.id.etDescripcionEvento)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarEvento)

        val eventoRepo = EventoRepository(this)

        btnGuardar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val fecha = etFecha.text.toString()
            val descripcion = etDescripcion.text.toString()

            if (titulo.isNotEmpty() && fecha.isNotEmpty() && descripcion.isNotEmpty()) {
                val evento = Evento(titulo = titulo, fecha = fecha, descripcion = descripcion)
                eventoRepo.insertarEvento(evento)
                Toast.makeText(this, "Evento guardado", Toast.LENGTH_SHORT).show()
                etTitulo.text.clear()
                etFecha.text.clear()
                etDescripcion.text.clear()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
