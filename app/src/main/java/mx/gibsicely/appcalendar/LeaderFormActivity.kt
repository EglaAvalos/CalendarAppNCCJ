package mx.gibsicely.appcalendar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LeaderFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader_form) // Tu layout XML para el formulario

        val nombreEditText: EditText = findViewById(R.id.etLeaderName)
        val puestoEditText: EditText = findViewById(R.id.etLeaderPosition)
        val telefonoEditText: EditText = findViewById(R.id.etLeaderPhone)
        val saveButton: Button = findViewById(R.id.btnSaveLeader)

        saveButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val puesto = puestoEditText.text.toString()
            val telefono = telefonoEditText.text.toString()

            val nuevoLider = Leader(R.drawable.user_icon, nombre, puesto, telefono)

            finish()
        }
    }
}
