package com.mroz.mateusz.cvapplication.ui

import com.mroz.mateusz.cvapplication.api.ApiService
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.util.AutoSingleObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


open class MainPresenter @Inject constructor(private val apiService: ApiService) {

    @Inject
    lateinit var disposable: CompositeDisposable
    lateinit var view: MainView

    fun loadBaseInfo() {
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
    }
}