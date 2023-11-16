package com.example.films
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
 data class Film(
    val title: String,
    val poster: Int,
    val description: String
) : Parcelable