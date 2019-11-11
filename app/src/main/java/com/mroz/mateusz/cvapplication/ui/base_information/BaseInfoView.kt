package com.mroz.mateusz.cvapplication.ui.base_information

import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo


interface BaseInfoView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String)
    fun inputBaseInfo(baseInfo: BaseInfo)
}