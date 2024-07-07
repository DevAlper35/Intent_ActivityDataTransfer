package com.mudurlu.intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mudurlu.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAktar.setOnClickListener {
            val ad = binding.editAd.text.toString()
            val soyad = binding.editSoyad.text.toString()
            val meslek = binding.editMeslek.text.toString()
            val sehir = binding.editSehir.text.toString()

            val ikinciSayfa = Intent(this,IkinciActivity::class.java)
            ikinciSayfa.putExtra("ad",ad)
            ikinciSayfa.putExtra("soyad",soyad)
            ikinciSayfa.putExtra("meslek",meslek)
            ikinciSayfa.putExtra("sehir", sehir)

            startActivity(ikinciSayfa)

        }


    }
}