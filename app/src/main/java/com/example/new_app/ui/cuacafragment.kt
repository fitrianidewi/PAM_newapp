import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.new_app.R
import com.example.new_app.Adapter.cuacalistadapter
import com.example.new_app.model.cuacalist
import com.example.new_app.remote.APIcuaca
import org.json.JSONException
import pl.droidsonroids.gif.GifImageView

class cuacafragment : Fragment() {
    private val API_URL = APIcuaca.API_URL

    private lateinit var tvTime: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvDayDate: TextView
    private lateinit var tvMaxTemp: TextView
    private lateinit var tvMinTemp: TextView
    private lateinit var tvStatus: TextView
    private lateinit var imgCuaca: GifImageView

    private val mWeatherList = ArrayList<cuacalist>()
    private val adapterWeather = cuacalistadapter(mWeatherList)
    private lateinit var mProgress: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cuacafragment, container, false)

        tvTime = view.findViewById(R.id.tvTime)
        tvCity = view.findViewById(R.id.tvCity)
        tvDayDate = view.findViewById(R.id.tvDayDate)
        tvMaxTemp = view.findViewById(R.id.tvMaxTemp)
        tvMinTemp = view.findViewById(R.id.tvMinTemp)
        tvStatus = view.findViewById(R.id.tvStatus)
        imgCuaca = view.findViewById(R.id.imgCuaca)

        mProgress = AlertDialog.Builder(requireActivity()).create()
        mProgress.setTitle("Mohon tunggu")
        mProgress.setCancelable(false)
        mProgress.setMessage("Sedang menampilkan data...")
        mProgress.show()

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleList)
        recyclerView.adapter = adapterWeather
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, API_URL, null,
            Response.Listener { _ ->
                try {
                    // ... your existing code ...
                    mProgress.dismiss()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener {
                Toast.makeText(requireActivity(), "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
            })

        Volley.newRequestQueue(requireContext()).add(jsonObjectRequest)

        return view
    }
}