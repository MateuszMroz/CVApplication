package com.mroz.mateusz.cvapplication.ui.projects

import com.mroz.mateusz.cvapplication.data.remote.ApiService
import javax.inject.Inject


class ProjectsPresenter @Inject constructor(private val apiService: ApiService) {

    lateinit var view: ProjectsView

    /*fun loadProjects() {
        view.showLoader()
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

            })
    }*/
}