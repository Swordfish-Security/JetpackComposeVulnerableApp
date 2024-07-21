package ru.ptsecurity.navigation_example.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "PTSECURITY"
        private const val DATABASE_VERSION = 1
        const val TABLE_USER_NAME = "user"
        const val NAME = "name"
        const val SURNAME = "surname"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUserTable = ("CREATE TABLE " + TABLE_USER_NAME + " ("
                + NAME + " TEXT, "
                + SURNAME + " TEXT" + ")")

        db.execSQL(createUserTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER_NAME")
        onCreate(db)
    }

    fun saveUserData(name: String, surname: String) {
        val values = ContentValues()
        values.put(NAME, name)
        values.put(SURNAME, surname)

        val db = this.writableDatabase
        db.insert(TABLE_USER_NAME, null, values)
        db.close()
    }
}