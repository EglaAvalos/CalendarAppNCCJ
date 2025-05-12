package mx.gibsicely.appcalendar

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class UserRepository(context: Context) {
    private val dbHelper = DataBase(context)

    fun login(username: String, password: String): Int? {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT is_admin FROM users WHERE username = ? AND password = ?",
            arrayOf(username, password)
        )

        return if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex("is_admin")
            if (columnIndex != -1) {  // Verificamos si la columna existe
                val isAdmin = cursor.getInt(columnIndex)
                cursor.close()
                isAdmin
            } else {
                cursor.close()
                null
            }
        } else {
            cursor.close()
            null
        }
    }


    // Cambié aquí para que retorne el resultado de la inserción
    fun insertUser(username: String, password: String, isAdmin: Int): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("username", username)
            put("password", password)
            put("is_admin", isAdmin)
        }

        // Retorna el id de la fila insertada o -1 si hubo un error
        return db.insert("users", null, values)
    }
}
