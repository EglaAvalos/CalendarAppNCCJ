package mx.gibsicely.appcalendar

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

data class Evento(
    val id: Int = 0,
    val titulo: String,
    val fecha: String,
    val descripcion: String
)

class EventoRepository(context: Context) {
    private val dbHelper = DataBase(context)

    fun insertarEvento(evento: Evento): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("titulo", evento.titulo)
            put("fecha", evento.fecha)
            put("descripcion", evento.descripcion)
        }
        return db.insert("eventos", null, values)
    }

    fun obtenerEventos(): List<Evento> {
        val db = dbHelper.readableDatabase
        val listaEventos = mutableListOf<Evento>()
        val cursor = db.rawQuery("SELECT * FROM eventos", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val titulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo"))
                val fecha = cursor.getString(cursor.getColumnIndexOrThrow("fecha"))
                val descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"))

                val evento = Evento(id, titulo, fecha, descripcion)
                listaEventos.add(evento)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return listaEventos
    }

    fun actualizarEvento(evento: Evento): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("titulo", evento.titulo)
            put("fecha", evento.fecha)
            put("descripcion", evento.descripcion)
        }
        return db.update("eventos", values, "id = ?", arrayOf(evento.id.toString()))
    }

    fun eliminarEvento(id: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("eventos", "id = ?", arrayOf(id.toString()))
    }
}
