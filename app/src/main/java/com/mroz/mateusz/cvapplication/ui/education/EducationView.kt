package com.mroz.mateusz.cvapplication.ui.education

import com.mroz.mateusz.cvapplication.ui.education.model.Education


interface EducationView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String)
    fun updateAdapter(listEducationPosition: List<Education>)
}