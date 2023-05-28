package com.example.uasapb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    val date: String,
    val nameRace: String,
    val nameCircuit: String,
    val imgCircuit: Int,
) : Parcelable