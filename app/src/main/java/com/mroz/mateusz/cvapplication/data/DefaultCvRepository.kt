package com.mroz.mateusz.cvapplication.data

import com.mroz.mateusz.cvapplication.data.remote.CvRemoteDataSource
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import javax.inject.Inject

class DefaultCvRepository @Inject constructor(
    private val cvRemoteDataSource: CvRemoteDataSource
) : CvRepository {

    override suspend fun getBaseInformation(forceUpdate: Boolean): BaseInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getEducationPosition(forceUpdate: Boolean): List<Education> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getExperience(forceUpdate: Boolean): List<Experience> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getProjects(forceUpdate: Boolean): List<Project> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSkills(forceUpdate: Boolean): Result<List<Skill>> =
        cvRemoteDataSource.getSkills()


}