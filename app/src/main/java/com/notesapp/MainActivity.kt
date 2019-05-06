package com.notesapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*


class MainActivity : AppCompatActivity() {

    var listNotes = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add dummy data
        listNotes.add(Note(1, "Meet Professor", "Note Description"))
        listNotes.add(Note(2, "Moroni 7", "47 But charity is the pure love of Christ, and it endureth forever; and whoso is found possessed of it at the last day, it shall be well with him."))
        listNotes.add(Note(3, "Meet Doctor", "Note Description"))

        var myNotesAdapter = MyNotesAdapter(listNotes)
        notesLV.adapter = myNotesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val sv = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_LONG).show()
                // TODO search database
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when (item.itemId) {
                R.id.miNewNote -> {
                    // Go to 'Add New Note' screen
                    var intent = Intent(this, AddNotes::class.java)
                    startActivity(intent)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    inner class MyNotesAdapter : BaseAdapter {
        var listNotesAdapter = ArrayList<Note>()
        constructor(listNotesAdapter: ArrayList<Note>) : super() {
            this.listNotesAdapter = listNotesAdapter
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.ticket, null)
            var myNote = listNotesAdapter[position]
            myView.titleTV.text = myNote.noteName
            myView.desTV.text = myNote.noteDes

            return myView
        }

        override fun getItem(position: Int): Any {
            return listNotesAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listNotesAdapter.size
        }
    }
}



