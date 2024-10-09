package com.dicoding.animeapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.animeapp.databinding.ItemRowAnimeBinding

class AnimeAdapter(private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<AnimeAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowAnimeBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, synopsis, rating, photo) = listAnime[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemTitle.text = title
        holder.binding.tvItemSynopsis.text = synopsis
        val ratingText = holder.itemView.context.getString(R.string.rating, rating)
        holder.binding.tvItemRating.text = ratingText
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("extra_anime", listAnime[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listAnime.size

    class ListViewHolder(var binding: ItemRowAnimeBinding) : RecyclerView.ViewHolder(binding.root)
}
