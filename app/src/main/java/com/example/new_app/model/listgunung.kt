package com.example.new_app.model

data class listgunung(
    val gunung: List<Gunung>
) {
    val strLong: Double
    val strLat: Double
    val strInfoGunung: String?
    val strJalurPendakian: String?
    val strDeskripsi: String?
    val strNamaGunung: String?
    val strLokasiGunung: String
    val strImageGunung: Any
    
    }
}