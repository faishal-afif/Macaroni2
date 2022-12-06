package com.example.macaroni.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.macaroni.databinding.ActivityNewNoteBinding

class NewMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}