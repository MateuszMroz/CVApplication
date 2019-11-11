package com.mroz.mateusz.cvapplication.ui.education

import com.mroz.mateusz.cvapplication.api.ApiService
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.util.AutoSingleObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class EducationPresenter @Inject constructor(private val apiService: ApiService) {

    @Inject
    lateinit var disposable: CompositeDisposable
    lateinit var view: EducationView

    fun loadEducationPosition() {
        view.showLoader()
        apiService.getEducationPosition()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : AutoSingleObservable<List<Education>>(disposable) {
                override fun success(t: List<Education>) {
                    view.updateAdapter(t)
                    view.hideLoader()
                }

                override fun error(e: Throwable) {
                    view.hideLoader()
                    view.showMessage(e.message.toString())
                }
            })
    }

    fun destroy() {
        disposable.clear()
    }
}