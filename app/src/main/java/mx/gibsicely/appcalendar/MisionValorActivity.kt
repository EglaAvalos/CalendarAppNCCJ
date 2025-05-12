package mx.gibsicely.appcalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MisionValorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misonvalor) // El layout que hemos modificado

        val tvMission: TextView = findViewById(R.id.tvMission)
        val tvValues: TextView = findViewById(R.id.tvValues)

    }
}
