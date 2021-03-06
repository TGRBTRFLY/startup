package com.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbManager {

    val dbName = "MyNotesdb"
    val dbTable = "NotesTable"
    val callID = "ID"
    val callTitle = "Title"
    val callDes = "Description"
    val dbVersion = 1
    // CREATE TABLE IF NOT EXISTS (ID INTEGER PRIMARY KEY, title TEXT, Description TEXT);"
    val sqlCreatedTable =
        "CREATE TABLE IF NOT EXISTS " +
            dbTable + " (" + callID + " INTEGER PRIMARY KEY, " + callTitle +
            " TEXT, " + callDes + " TEXT);"
    var sqlDB: SQLiteDatabase? = null

    constructor(context: Context) {
        var db = DatabaseHelperNotes(context)
        sqlDB = db.writableDatabase
    }

    inner class DatabaseHelperNotes : SQLiteOpenHelper {
        var context: Context? = null

        constructor(context: Context) : super(context, dbName, null, dbVersion) {
            this.context = context

        }

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(sqlCreatedTable)
            Toast.makeText(this.context, "database is created", Toast.LENGTH_LONG).show()
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("Drop table IF EXISTS " + dbTable)
        }

    }

    fun Insert(values: ContentValues): Long {
        val ID = sqlDB!!.insert(dbTable, "", values)
        return ID

    }
}