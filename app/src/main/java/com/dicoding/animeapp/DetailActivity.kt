package com.dicoding.animeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.animeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anime = intent.getParcelableExtra<Anime>("extra_anime") as Anime
        binding.tvDetailTitle.text = anime.title
        binding.tvDetailSynopsis.text = anime.synopsis
        val rating = getString(R.string.rating, anime.rating)
        binding.tvDetailRating.text = rating

        Glide.with(this)
            .load(anime.photo)
            .into(binding.imgDetailPhoto)

        binding.actionShare.setOnClickListener {
            shareAnime(anime)
        }
    }

    private fun shareAnime(anime: Anime) {
        val shareText = "Check out this anime:\nName: ${anime.title}\nRating: ${anime.rating}\nSynopsis: ${anime.synopsis}"
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}
