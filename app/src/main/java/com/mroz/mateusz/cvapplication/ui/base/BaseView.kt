package com.mroz.mateusz.cvapplication.ui.base

import android.view.View


interface BaseView {

    fun message(message: String?, view: View)

    fun loaderOn()

    fun loaderOff()
}