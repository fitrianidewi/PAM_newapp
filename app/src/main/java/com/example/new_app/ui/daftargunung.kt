package com.example.new_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.new_app.R
import com.example.new_app.model.Volcano
import com.example.new_app.remote.ApiClient
import retrofit2.Callback
import retrofit2.Response
import com.example.new_app.Adapter.MainAdapter

class daftargunung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftargunung)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val call = ApiClient.apiService.getVolcanoes()
        call.enqueue(object : Callback<List<Volcano>> {
            override fun onResponse(call: Call<List<Volcano>>, response: Response<List<Volcano>>) {
                if (response.isSuccessful) {
                    val volcanoes = response.body()
                    if (volcanoes != null) {
                        val adapter = MainAdapter(volcanoes)
                        recyclerView.adapter = adapter
                    }
                } else {
                    // Handle kesalahan
                }
            }

            override fun onFailure(call: Call<List<Volcano>>, t: Throwable) {
                // Handle kesalahan jaringan
            }
        })
    }
}