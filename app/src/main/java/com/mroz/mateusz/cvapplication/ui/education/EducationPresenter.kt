package com.mroz.mateusz.cvapplication.ui.education

import com.mroz.mateusz.cvapplication.data.remote.ApiService
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import java.util.concurrent.CancellationException
import javax.inject.Inject


class EducationPresenter @Inject constructor(private val apiService: ApiService) {

    lateinit var view: EducationView

    suspend fun loadEducationPosition(job: Job): List<Education> {
        view.showLoader()

        val listOfEducation = apiService.getEducationPosition()
        delay(2000L)
        job.cancel(CancellationException("Try cancel work!"))
        view.hideLoader()

        return listOfEducation
    }

}