package com.example.new_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.model.Volcano

class MainAdapter(private val volcanoes: List<Volcano>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewElevation: TextView = itemView.findViewById(R.id.textViewElevation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_daftargunung, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val volcano = volcanoes[position]
        holder.textViewName.text = volcano.name
        holder.textViewElevation.text = "Elevation: ${volcano.elevation} meters"
    }

    override fun getItemCount(): Int {
        return volcanoes.size
    }
}


