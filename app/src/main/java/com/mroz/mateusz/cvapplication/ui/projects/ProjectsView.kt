package com.mroz.mateusz.cvapplication.ui.projects

import com.mroz.mateusz.cvapplication.ui.projects.model.Project


interface ProjectsView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String)
    fun updateAdapter(listProjects: List<Project>)
}