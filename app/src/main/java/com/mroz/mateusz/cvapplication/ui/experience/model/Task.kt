package com.mroz.mateusz.cvapplication.ui.experience.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(
    val name:String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}