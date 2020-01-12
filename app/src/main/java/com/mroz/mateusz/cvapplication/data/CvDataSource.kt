package com.mroz.mateusz.cvapplication.data

import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill


interface CvDataSource {

    suspend fun getBaseInformation(): BaseInfo

    suspend fun getEducationPosition(): List<Education>

    suspend fun getExperience(): List<Experience>

    suspend fun getProjects(): List<Project>

    suspend fun getSkills(): Result<List<Skill>>
}