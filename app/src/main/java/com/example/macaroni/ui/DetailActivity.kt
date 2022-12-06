package com.example.macaroni.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.macaroni.database.Dummy
import com.example.macaroni.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteId = intent.getLongExtra(EXTRA_ID, 0) ?: ""
        val note = Dummy.getDetailNote(noteId as Long)
        binding.apply {
            tvTitle.text = note.title
            tvPrice.text = note.price
            tvDescription.text = note.description
        }
    }
}
