package com.scifi.valesport

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Esport(
    val name: String,
    val description: String,
    val logo: String,
    val roster: String,
    val earning: String,
    val achievement: String,
    val site: String,
    val photo: String
) : Parcelable
