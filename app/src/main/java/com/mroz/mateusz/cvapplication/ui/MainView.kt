package com.mroz.mateusz.cvapplication.ui

import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo


interface MainView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String?)
    fun updateBaseInfo(baseInfo: BaseInfo)
}