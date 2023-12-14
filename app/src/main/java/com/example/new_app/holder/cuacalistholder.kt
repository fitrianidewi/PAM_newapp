package com.example.new_app.holder

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.model.cuacalist
import pl.droidsonroids.gif.GifImageView

class cuacalistholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val maxTempList: TextView = itemView.findViewById(R.id.maxTempList)
    private val minTempList: TextView = itemView.findViewById(R.id.minTempList)
    private val statusList: TextView = itemView.findViewById(R.id.statusList)
    private val timeList: TextView = itemView.findViewById(R.id.timeList)
    private val statusDetail: TextView = itemView.findViewById(R.id.statusDetail)
    private val iconMiniList: GifImageView = itemView.findViewById(R.id.iconMiniList)

    @SuppressLint("SetTextI18n")
    fun updateUI(weatherList: cuacalist) {
        maxTempList.text = "${weatherList.tempMax} ${0x00B0.toChar()}C"
        minTempList.text = "${weatherList.tempMin} ${0x00B0.toChar()}C"
        statusList.text = weatherList.status
        timeList.text = weatherList.time
        statusDetail.text = weatherList.statusDetail

        when (weatherList.status) {
            "Rain" -> iconMiniList.setImageResource(R.drawable.hujan)
            "Clouds" -> iconMiniList.setImageResource(R.drawable.awan)
            else -> iconMiniList.setImageResource(R.drawable.cerah)
        }
    }
}
