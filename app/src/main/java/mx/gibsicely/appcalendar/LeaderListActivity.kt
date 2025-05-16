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
            Leader(R.drawable.pastor_myke, "Miguel Fino", "Pastor", "6221464976"),
            Leader(R.drawable.isela_damas, "Isela Americano", "Dpto.Damas", "6221453971"),
            Leader(R.drawable.luis_caballeros, "Luis Nuñez", "Dpto.Jovenes", "6221135309"),
            Leader(R.drawable.rosalva_ujier, "Rosalva Rosas", "Ujier", "6221706191"),
            Leader(R.drawable.rocio_staff, "Rocio Dalblar", "Staff", "6221477010"),
            Leader(R.drawable.fabiola_kids, "Fabiola Elenez", "NCCJ kids", "6221789934"),
            Leader(R.drawable.banuelos_nccj, "Rodolfo Bañuelos", "Supervisor NCCJ", "6428219034")
        )

        val adapter = LeaderAdapter(this, listaLideres)
        listView.adapter = adapter


    }
}
