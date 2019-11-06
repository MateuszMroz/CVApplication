package com.mroz.mateusz.cvapplication.ui.projects.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Project(
    val time: String,
    val name: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}