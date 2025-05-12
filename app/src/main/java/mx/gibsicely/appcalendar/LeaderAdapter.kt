package mx.gibsicely.appcalendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeaderAdapter(private val listaLideres: List<Leader>) :
    RecyclerView.Adapter<LeaderAdapter.LiderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiderViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leader, parent, false)
        return LiderViewHolder(vista)
    }

    override fun onBindViewHolder(holder: LiderViewHolder, position: Int) {
        val lider = listaLideres[position]
        holder.imagen.setImageResource(lider.imagenResId)
        holder.nombre.text = lider.nombre
        holder.puesto.text = lider.puesto
        holder.telefono.text = lider.telefono
    }

    override fun getItemCount(): Int = listaLideres.size

    class LiderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.ivLeaderPhoto)
        val nombre: TextView = itemView.findViewById(R.id.tvLeaderName)
        val puesto: TextView = itemView.findViewById(R.id.tvLeaderPosition)
        val telefono: TextView = itemView.findViewById(R.id.tvLeaderPhone)
    }
}
