package com.mroz.mateusz.cvapplication.ui.skills

import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup


interface SkillsView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String)
    fun loadSkillList(listSkills: List<SkillsGroup>)
}