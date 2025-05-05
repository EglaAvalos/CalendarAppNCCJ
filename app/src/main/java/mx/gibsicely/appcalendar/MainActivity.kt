package mx.gibsicely.appcalendar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Espera de 2 segundos uwu
        Handler().postDelayed({
            startActivity(Intent(this, PresentationActivity::class.java))
            finish()
        }, 2000)
    }
}
