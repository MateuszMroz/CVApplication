package com.mroz.mateusz.cvapplication.ui.base_information.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BaseInfo(
    val address:String,
    val phoneNumber: String,
    val mail:String,
    val github:String,
    val linkedIn: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}