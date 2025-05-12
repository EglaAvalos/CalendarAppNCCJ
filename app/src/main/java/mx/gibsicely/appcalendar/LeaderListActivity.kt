package mx.gibsicely.appcalendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LeaderListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lideres)


        val listaLideres = listOf(
            Leader(R.drawable.user_icon, "Miguel Avalos", "Pastor", "6221464976"),
            Leader(R.drawable.user_icon, "Elizabeth Hernandez", "Dpto. Damas", "6221237899"),

        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewLeaders)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = LeaderAdapter(listaLideres)
        recyclerView.adapter = adapter
    }
}
