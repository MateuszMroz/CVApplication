package com.mroz.mateusz.cvapplication.ui.experience

import com.mroz.mateusz.cvapplication.ui.experience.adapter.ExperienceGroup


interface ExperienceView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String)
    fun loadExperienceList(listExperience: List<ExperienceGroup>)
}