package com.example.macaroni.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.macaroni.databinding.ActivityNewMenuBinding

class NewMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}