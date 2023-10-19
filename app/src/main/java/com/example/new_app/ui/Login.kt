package com.example.new_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.example.new_app.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.emailtext.text.toString()
            val pass = binding.passtext.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, home::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Mohon isi dengan benar", Toast.LENGTH_SHORT).show()
            }
        }


        binding.textView.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        fun kesignup(view: View) {
            //setContentView(R.layout.activity_main)
            //explicit intent
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, register::class.java))
                finish()
            }, 300)
        }

        //fun kehome(view: View) {
            //setContentView(R.layout.activity_main)
            //explicit intent
           // Handler(Looper.getMainLooper()).postDelayed({
               // startActivity(Intent(this, home::class.java))
              //  finish()
           // }, 30)
        //}
    }
}