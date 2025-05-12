package mx.gibsicely.appcalendar

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EditMisionValoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_mision_valores)

        val etMision = findViewById<EditText>(R.id.etMision)
        val etValores = findViewById<EditText>(R.id.etValores)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarMV)

        val prefs = getSharedPreferences("config", Context.MODE_PRIVATE)
        etMision.setText(prefs.getString("mision", ""))
        etValores.setText(prefs.getString("valores", ""))

        btnGuardar.setOnClickListener {
            val mision = etMision.text.toString()
            val valores = etValores.text.toString()

            prefs.edit().putString("mision", mision).putString("valores", valores).apply()
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
        }
    }
}
