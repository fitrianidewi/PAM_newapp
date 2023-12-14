package com.example.new_app.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.new_app.databinding.ActivityRegisterBinding
import com.example.new_app.db.UserEntity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class register() : AppCompatActivity(), Parcelable {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    constructor(parcel: Parcel) : this() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val fullname = binding.fullnametext.text.toString()
            val email = binding.emailtext.text.toString()
            val pass = binding.passtext.text.toString()
            val confirmpass = binding.confirmpass.text.toString()

            if (fullname.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty()) {
                if (pass == confirmpass) {
                    // Simpan user ke database Room
                    val userDao = MyApp.database.userDao()

                    GlobalScope.launch(Dispatchers.IO) {
                        val user = UserEntity(fullname = fullname, email = email, password = pass)
                        userDao.insertUser(user)
                    }

                    // Pindah ke activity selanjutnya
                    moveToNextActivity()
                } else {
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Mohon isi dengan benar", Toast.LENGTH_SHORT).show()
            }
        }

        fun kesignin(view: View) {
            //setContentView(R.layout.activity_main)
            //explicit intent
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, login::class.java))
                finish()
            }, 300)
        }

        fun kehome(view: View) {
            //setContentView(R.layout.activity_main)
            //explicit intent
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }, 30)
        }
    }
    private fun moveToNextActivity() {
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish() // Jika Anda ingin menutup activity saat ini
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    fun kesignin(view: View) {
        //setContentView(R.layout.activity_main)
        //explicit intent
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, login::class.java))
            finish()
        }, 300)
    }

    companion object CREATOR : Parcelable.Creator<register> {
        override fun createFromParcel(parcel: Parcel): register {
            return register(parcel)
        }

        override fun newArray(size: Int): Array<register?> {
            return arrayOfNulls(size)
        }
    }
}