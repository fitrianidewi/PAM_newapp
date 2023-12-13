package com.example.new_app.ui

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.Adapter.AdapterGunung
import com.example.new_app.R
import com.example.new_app.model.Gunung
import java.util.Locale

class search : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private val listGunung = ArrayList<Gunung>()
    private val listFilteredGunung = ArrayList<Gunung>()
    private lateinit var adapterGunung: AdapterGunung

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchView = findViewById(R.id.searchView)
        recyclerView = findViewById(R.id.listgunung)

        // Initialize list gunung
        listGunung.clear()
        listFilteredGunung.clear()

        // Load gunung data
        loadGunungData()

        // Set up searchView
        searchView.setOnQueryTextListener(this)
        searchView.setIconifiedByDefault(false)
        searchView.setQueryHint("Search your destination")
        searchView.clearFocus()

        // Set up recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapterGunung = AdapterGunung(listFilteredGunung)
        recyclerView.adapter = adapterGunung
    }

    private fun loadGunungData() {
        // Load gunung data from database or API
        // and add it to the listGunung
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let { search(it) }
        return false
    }

    private fun search(query: String) {
        // Reset listFilteredGunung
        listFilteredGunung.clear()

        // Filter gunung based on query
        for (gunung in listGunung) {
            if (gunung.nama_gunung.contains(query.lowercase(Locale.getDefault()))) {
                listFilteredGunung.add(gunung)
            }
        }

        // Update adapter
        adapterGunung.notifyDataSetChanged()
    }
}
