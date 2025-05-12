package mx.gibsicely.appcalendar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelpCenterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helpcenter) // El layout con el botón

        val btnDownloadManual: Button = findViewById(R.id.btnDownloadManual)

        // Configurar el botón para abrir un enlace de descarga o mostrar un PDF
        btnDownloadManual.setOnClickListener {
            // Aquí puedes poner la URL de donde se encuentra el PDF
            val pdfUrl = "https://www.ejemplo.com/manual_de_usuario.pdf"

            try {
                // Intent para abrir el enlace del PDF
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Error al intentar descargar el manual", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
