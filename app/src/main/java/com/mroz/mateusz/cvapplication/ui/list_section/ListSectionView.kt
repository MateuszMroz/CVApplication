package com.mroz.mateusz.cvapplication.ui.list_section


interface ListSectionView {
    fun showLoader()
    fun hideLoader()
    fun showMessage(text: String)
    fun initializeListSection()
}