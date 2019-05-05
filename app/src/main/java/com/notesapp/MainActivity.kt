package com.notesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var listNotes = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add dummy data
        listNotes.add(Note(1, "Meet Professor", "Note Description"))
        listNotes.add(Note(2, "Meet Friend", "Note Description"))
        listNotes.add(Note(3, "Meet Doctor", "Note Description"))

    }
}
