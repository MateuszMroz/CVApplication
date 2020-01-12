package com.mroz.mateusz.cvapplication.data

import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill


interface CvRepository {

    suspend fun getBaseInformation(forceUpdate: Boolean = false): BaseInfo

    suspend fun getEducationPosition(forceUpdate: Boolean = false): List<Education>

    suspend fun getExperience(forceUpdate: Boolean = false): List<Experience>

    suspend fun getProjects(forceUpdate: Boolean = false): List<Project>

    suspend fun getSkills(forceUpdate: Boolean = false): List<Skill>
}