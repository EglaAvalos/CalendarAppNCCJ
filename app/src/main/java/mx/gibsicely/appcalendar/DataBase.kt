package mx.gibsicely.appcalendar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase(context: Context) : SQLiteOpenHelper(context, "AppCalendarDB", null, 2) {
    override fun onCreate(db: SQLiteDatabase) {
        val createUsersTable = """
        CREATE TABLE users (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            username TEXT NOT NULL UNIQUE,
            password TEXT NOT NULL,
            is_admin INTEGER NOT NULL
        )
    """.trimIndent()
        db.execSQL(createUsersTable)

        val createEventosTable = """
        CREATE TABLE eventos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            titulo TEXT NOT NULL,
            fecha TEXT NOT NULL,
            descripcion TEXT
        )
    """.trimIndent()
        db.execSQL(createEventosTable)

        val insertAdmin = """
        INSERT INTO users (username, password, is_admin) 
        VALUES ('myke', '3140', 1)
    """.trimIndent()
        db.execSQL(insertAdmin)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        db.execSQL("DROP TABLE IF EXISTS eventos")
        onCreate(db)
    }


}
