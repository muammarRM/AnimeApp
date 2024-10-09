package com.dicoding.animeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val title: String,
    val synopsis: String,
    val rating: String,
    val photo: String
) : Parcelable