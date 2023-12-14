package com.example.new_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.model.cuacalist

class cuacalistadapter(private val mWeatherList: List<cuacalist>) : RecyclerView.Adapter<cuacalistadapter.ViewHolder>() {

    // ... (lain-lain kode)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_cuaca, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cuacalist = mWeatherList[position]
        holder.timeView.text = cuacalist.time
        holder.dayView.text = cuacalist.day
        holder.tempMaxView.text = cuacalist.tempMax.toString()
        holder.tempMinView.text = cuacalist.tempMin.toString()
        holder.statusImageView.setImageResource(R.drawable.ic_sun) // Atur gambar berdasarkan status cuaca
    }

    override fun getItemCount() = mWeatherList.size

    // ... (lain-lain kode)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val timeView: TextView = view.findViewById(R.id.time)
        val dayView: TextView = view.findViewById(R.id.day)
        val tempMaxView: TextView = view.findViewById(R.id.tempMax)
        val tempMinView: TextView = view.findViewById(R.id.tempMin)
        val statusImageView: ImageView = view.findViewById(R.id.statusImage)
    }
}