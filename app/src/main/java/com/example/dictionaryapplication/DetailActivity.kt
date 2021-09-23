package com.example.dictionaryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dictionaryapplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word = intent.getSerializableExtra("object") as Words

        binding.detailEnglish.text = word.ingilizce
        binding.detailTurkish.text = word.turkce

    }
}