package com.mroz.mateusz.cvapplication.ui.list_section.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class About(
    val name:String,
    val about:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}