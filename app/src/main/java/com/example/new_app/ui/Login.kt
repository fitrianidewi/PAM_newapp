package com.example.new_app.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.new_app.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.emailtext.text.toString()
            val pass = binding.passtext.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                // Check user credentials in Room Database
                GlobalScope.launch(Dispatchers.IO) {
                    val userDao = MyApp.database.userDao()
                    val user = userDao.getUserByEmailAndPassword(email, pass)

                    if (user != null) {
                        // Credentials are correct
                        moveToHomeActivity()
                    } else {
                        // Credentials are incorrect
                        showToast("Email atau password salah")
                    }
                }
            } else {
                showToast("Mohon isi dengan benar")
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

        fun kehome(view: View) {
            //setContentView(R.layout.activity_main)
            //explicit intent
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }, 30)
        }



    }

    private fun moveToHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 30)
    }

    private fun showToast(s: String) {
        runOnUiThread {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        }
    }


}