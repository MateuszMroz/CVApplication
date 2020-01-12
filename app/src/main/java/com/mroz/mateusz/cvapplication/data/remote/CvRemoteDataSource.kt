package com.mroz.mateusz.cvapplication.data.remote

import com.mroz.mateusz.cvapplication.data.CvDataSource
import com.mroz.mateusz.cvapplication.data.Result
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CvRemoteDataSource @Inject constructor(
    private val apiService: ApiService
): CvDataSource {

    override suspend fun getBaseInformation(): BaseInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getEducationPosition(): List<Education> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getExperience(): List<Experience> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getProjects(): List<Project> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSkills(): Result<List<Skill>> = withContext(Dispatchers.IO) {
        return@withContext  try {
            Result.Success(apiService.getSkills())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}