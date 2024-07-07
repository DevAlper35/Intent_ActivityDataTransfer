package com.mudurlu.intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mudurlu.intent.databinding.ActivityIkinciBinding

class IkinciActivity : AppCompatActivity() {

    private lateinit var binding :ActivityIkinciBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityIkinciBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textAd.text = intent.getStringExtra("ad")
        binding.textSoyad.text = intent.getStringExtra("soyad")
        binding.textMeslek.text = intent.getStringExtra("meslek")
        binding.textSehir.text = intent.getStringExtra("sehir")

    }
}