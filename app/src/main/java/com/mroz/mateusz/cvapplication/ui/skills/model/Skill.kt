package com.mroz.mateusz.cvapplication.ui.skills.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Skill(
    val skillType: String/*,
    val listSkill: List<SkillValue>*/
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}