package com.example.assignment8.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharactersDetail(
    val fullName: String,
    val nickName: String?,
    val hogwartsHouse: String,
    val interpretedBy: String,
    val children: List<String>,
    val image: String,
    val birthdate: String,
    val index: Double
) : Parcelable
