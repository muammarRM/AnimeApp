package com.dicoding.animeapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)
        list.addAll(getListAnime())
        showRecyclerList()
    }

    private fun getListAnime(): ArrayList<Anime> {
        val dataTitle = resources.getStringArray(R.array.anime_titles)
        val dataSynopsis = resources.getStringArray(R.array.anime_synopsis)
        val dataRating = resources.getStringArray(R.array.anime_ratings)
        val dataPhoto = resources.getStringArray(R.array.anime_photos)
        val listAnime = ArrayList<Anime>()
        for (i in dataTitle.indices) {
            val anime = Anime(dataTitle[i], dataSynopsis[i], dataRating[i], dataPhoto[i])
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        rvAnime.adapter = AnimeAdapter(list)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
