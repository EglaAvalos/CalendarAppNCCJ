package mx.gibsicely.appcalendar

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LeaderListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lideres)


        val listView: ListView = findViewById(R.id.listViewLeaders)

        val listaLideres = listOf(
            Leader(R.drawable.pastor_myke, "Miguel Avalos", "Pastor", "6221464976"),
            Leader(R.drawable.user_icon, "Isela Morales", "Dpto.Damas", "6221235698"),
            Leader(R.drawable.user_icon, "Rocio Munguia", "Dpto.Jovenes", "6221135309"),
            Leader(R.drawable.user_icon, "Luis Hernandez", "Dpto.Caballeros", "6641903901"),
            Leader(R.drawable.user_icon, "Fabiola Nuñez", "NCCJ kids", "6621390233"),
            Leader(R.drawable.user_icon, "Manuel Bañuelos", "Supervisor NCCJ", "6428219034")
        )

        val adapter = LeaderAdapter(this, listaLideres)
        listView.adapter = adapter


    }
}
