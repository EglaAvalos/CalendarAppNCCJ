package mx.gibsicely.appcalendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class LeaderAdapter(
    context: Context,
    private val listaLideres: List<Leader>
) : ArrayAdapter<Leader>(context, 0, listaLideres) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_leader, parent, false)

        val lider = listaLideres[position]
        val imagen = view.findViewById<ImageView>(R.id.ivLeaderPhoto)
        val nombre = view.findViewById<TextView>(R.id.tvLeaderName)
        val puesto = view.findViewById<TextView>(R.id.tvLeaderPosition)
        val telefono = view.findViewById<TextView>(R.id.tvLeaderPhone)

        imagen.setImageResource(lider.imagenResId)
        nombre.text = lider.nombre
        puesto.text = lider.puesto
        telefono.text = lider.telefono

        return view
    }
}
