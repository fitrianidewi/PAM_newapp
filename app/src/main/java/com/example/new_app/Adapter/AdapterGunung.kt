package com.example.new_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.model.Gunung

class AdapterGunung(private val listGunung: List<Gunung>) : RecyclerView.Adapter<AdapterGunung.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gunung_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gunung = gunungList[position]
        holder.textView.text = gunung.nama
        // Tampilkan gambar gunung berdasarkan link API
        // Gunakan library seperti Glide atau Picasso untuk mengelola gambar
    }

    override fun getItemCount() = gunungList.size
}