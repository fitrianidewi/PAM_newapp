package com.example.new_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.model.Gunung

class AdapterGunung(private val listGunung: List<Gunung>) : RecyclerView.Adapter<AdapterGunung.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail_gunung, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gunung = listGunung[position]
        holder.tvNamaGunung.text = gunung.nama_gunung
        // Tampilkan gambar gunung (jika ada) di sini
    }

    override fun getItemCount() = listGunung.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaGunung: TextView = itemView.findViewById(R.id.tvNamaGunung)
    }
}