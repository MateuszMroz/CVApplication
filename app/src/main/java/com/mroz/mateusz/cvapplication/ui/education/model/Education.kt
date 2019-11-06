package com.mroz.mateusz.cvapplication.ui.education.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Education(
    val data: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}