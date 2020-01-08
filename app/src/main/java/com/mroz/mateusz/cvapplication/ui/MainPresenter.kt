package com.mroz.mateusz.cvapplication.ui

import com.mroz.mateusz.cvapplication.data.remote.ApiService
import javax.inject.Inject


open class MainPresenter @Inject constructor(private val apiService: ApiService) {
    lateinit var view: MainView

    /*fun loadBaseInfo() {
        view.showLoader()
        apiService.getBaseInformation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : AutoSingleObservable<BaseInfo>(disposable) {
                override fun success(t: BaseInfo) {
                    view.hideLoader()
                    view.updateBaseInfo(t)
                }

                override fun error(e: Throwable) {
                    view.hideLoader()
                    view.showMessage(e.message.toString())
                }
            })
    }*/
}