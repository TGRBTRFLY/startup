package com.notesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AddNotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
    }

    fun bAdd(view: View) {
        finish()
    }
}
