package com.mroz.mateusz.cvapplication.ui.skills.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SkillValue(
    val skill:String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}