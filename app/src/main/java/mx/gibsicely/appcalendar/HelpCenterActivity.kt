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
        setContentView(R.layout.activity_helpcenter)

        val btnDownloadManual: Button = findViewById(R.id.btnDownloadManual)

        btnDownloadManual.setOnClickListener {
            // Aquí puedes poner la URL de donde se encuentra el PDF
            val pdfUrl = "https://www.ejemplo.com/manual_de_usuario.pdf"

            try {

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Error al intentar descargar el manual", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
