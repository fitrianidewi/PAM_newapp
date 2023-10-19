package com.example.new_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import com.example.new_app.R
import com.example.new_app.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class register() : AppCompatActivity(), Parcelable {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth


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

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
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
                startActivity(Intent(this, home::class.java))
                finish()
            }, 30)
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
}