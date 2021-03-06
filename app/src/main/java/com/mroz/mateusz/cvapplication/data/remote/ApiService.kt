package com.mroz.mateusz.cvapplication.data.remote

import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("baseInfo")
    fun getBaseInformation(): Single<BaseInfo>

    @GET("education")
    suspend fun getEducationPosition(): List<Education>

    @GET("experience")
    fun getExperience(): Single<List<Experience>>

    @GET("projects")
    fun getProjects(): Single<List<Project>>

    @GET("skills")
    suspend fun getSkills(): List<Skill>

}