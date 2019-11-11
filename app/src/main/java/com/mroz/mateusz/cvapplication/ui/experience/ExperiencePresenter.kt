package com.mroz.mateusz.cvapplication.ui.experience

import com.mroz.mateusz.cvapplication.api.ApiService
import com.mroz.mateusz.cvapplication.ui.experience.adapter.ExperienceGroup
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.util.AutoSingleObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ExperiencePresenter @Inject constructor(private val apiService: ApiService) {

    @Inject
    lateinit var disposable: CompositeDisposable
    lateinit var view: ExperienceView

    fun loadExperience() {
        view.showLoader()
        apiService.getExperience()
            .subscribeOn(Schedulers.io())
            .map {
                mapToExpandableList(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : AutoSingleObservable<List<ExperienceGroup>>(disposable) {
                override fun success(t: List<ExperienceGroup>) {
                    view.hideLoader()
                    view.loadExperienceList(t)
                }

                override fun error(e: Throwable) {
                    view.hideLoader()
                    view.showMessage(e.message.toString())
                }

            })
    }


    private fun mapToExpandableList(list: List<Experience>): List<ExperienceGroup> {
        val expandableList = mutableListOf<ExperienceGroup>()
        for (experience in list) {
            val title = "${experience.date}\n\n ${experience.workPlace}"
            val listTask = experience.tasks

            val expandableGroup = ExperienceGroup(title, listTask)
            expandableList.add(expandableGroup)
        }

        return expandableList
    }

}