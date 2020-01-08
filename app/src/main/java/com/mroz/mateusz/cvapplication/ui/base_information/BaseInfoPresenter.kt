package com.mroz.mateusz.cvapplication.ui.base_information

import com.mroz.mateusz.cvapplication.data.remote.ApiService
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import javax.inject.Inject


class BaseInfoPresenter @Inject constructor(private val apiService: ApiService) {
    lateinit var view: BaseInfoView
    lateinit var baseInfo: BaseInfo

    /*fun loadBaseInformation() {
        view.showLoader()
        apiService.getBaseInformation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : AutoSingleObservable<BaseInfo>(disposable) {
                override fun success(baseInfo: BaseInfo) {
                    this@BaseInfoPresenter.baseInfo = baseInfo
                    view.inputBaseInfo(baseInfo)
                    view.hideLoader()
                }

                override fun error(e: Throwable) {
                    view.hideLoader()
                    view.showMessage(e.message.toString())
                }
            })
    }*/

}