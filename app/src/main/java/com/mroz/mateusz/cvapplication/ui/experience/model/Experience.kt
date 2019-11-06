package com.mroz.mateusz.cvapplication.ui.experience.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Experience(
    val date: String,
    val header: String/*,
    val listTask: List<Task>*/
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}