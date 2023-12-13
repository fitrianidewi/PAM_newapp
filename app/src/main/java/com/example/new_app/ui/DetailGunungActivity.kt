package com.example.new_app.ui
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.new_app.R
import com.example.new_app.databinding.ActivityDetailGunungBinding
import com.example.new_app.model.NamaGunung
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Suppress("DEPRECATION")
class DetailGunungActivity : AppCompatActivity(), OnMapReadyCallback {

    private val strNamaGunung: String? = null
    private val dblLongitude: Double = 0.0
    private val dblLatitude: Double = 0.0
    private lateinit var binding: ActivityDetailGunungBinding
    private lateinit var namaGunung: NamaGunung
    private lateinit var googleMaps: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGunungBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Set transparent status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        val tools: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(tools)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        // Get data intent
        // NamaGunung = intent.getSerializableExtra(DETAIL_GUNUNG) as NamaGunung
        val strLokasiGunung = NamaGunung.strLokasiGunung
        val strNamaGunung = NamaGunung.strNamaGunung
        val strDeskripsi = NamaGunung.strDeskripsi
        val strJalurGunung = NamaGunung.strJalurPendakian
        val strInfoGunung = NamaGunung.strInfoGunung
        val dblLatitude = NamaGunung.strLat
        NamaGunung.strLong

        Glide.with(this)
            .load(NamaGunung.strImageGunung)
            .into(binding.imageGunung)

        binding.tvNamaGunung.text = strNamaGunung
        binding.tvLokasiGunung.text = strLokasiGunung
        binding.tvDeskripsi.text = strDeskripsi
        binding.tvJalurGunung.text = strJalurGunung
        binding.tvInfoGunung.text = strInfoGunung
    }

    // Set map
    override fun onMapReady(googleMap: GoogleMap) {
        googleMaps = googleMap
        val latLng = LatLng(dblLatitude, dblLongitude)
        googleMaps.addMarker(MarkerOptions().position(latLng).title(strNamaGunung))
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
        googleMaps.uiSettings.setAllGesturesEnabled(true)
        googleMaps.uiSettings.isZoomGesturesEnabled = true
        googleMaps.isTrafficEnabled = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val DETAIL_GUNUNG = "DETAIL_GUNUNG"
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }
}