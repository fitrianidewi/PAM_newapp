package com.example.new_app.model

data class NamaGunung(
    val deskripsi: String,
    val image_gunung: String,
    val info_gunung: String,
    val jalur_pendakian: String,
    val lat: Double,
    val lokasi: String,
    val lon: Double,
    val nama: String
) {
    companion object {
        val strImageGunung: Any = TODO()
        val strLong: Unit
        val strLat: Any
        val strInfoGunung: CharSequence?
        val strJalurPendakian: CharSequence?
        val strDeskripsi: CharSequence?
        val strNamaGunung: CharSequence?
        val strLokasiGunung: CharSequence?
    }
}