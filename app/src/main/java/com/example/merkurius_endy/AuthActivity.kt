package com.example.merkurius_endy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.merkurius_endy.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAuthBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

            //Kondisi jika isLogin bernilai true
            val isLogin = sharedPref.getBoolean("isLogin", false)
            if (isLogin) {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }

        binding.btnLogin.setOnClickListener {
            val username = binding.usernameText.text.toString()
            val password = binding.passwordText.text.toString()

            if(username==password){
                //Set value isLogin
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()

                //Berpindah ke main activity
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                    finish()
                } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Ooops...")
                    .setMessage("Username atau password salah!")
                    .show()
            }
        }

    }
}