package com.mroz.mateusz.cvapplication.ui.projects

import androidx.lifecycle.ViewModel
import com.mroz.mateusz.cvapplication.data.DefaultCvRepository
import com.mroz.mateusz.cvapplication.data.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ProjectsViewModel @Inject constructor(private val defaultCvRepository: DefaultCvRepository) :
    ViewModel(),
    CoroutineScope {

    private val job = Job()

    lateinit var view: ProjectsView

    fun loadProjects() {
        CoroutineScope(coroutineContext).launch {
            val result = defaultCvRepository.getSkills()
        }
        /*view.showLoader()
        apiService.getProjects()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : AutoSingleObservable<List<Project>>(disposable) {
                override fun success(t: List<Project>) {
                    view.updateAdapter(t)
                    view.hideLoader()
                }

                override fun error(e: Throwable) {
                    view.hideLoader()
                    view.showMessage(e.message.toString())
                }

            })*/
    }

    override val coroutineContext: CoroutineContext
        get() = IO + job
}