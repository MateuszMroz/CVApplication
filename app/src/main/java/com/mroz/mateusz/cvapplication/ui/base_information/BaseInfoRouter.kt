package com.mroz.mateusz.cvapplication.ui.base_information


interface BaseInfoRouter {
    fun navigateLocation(location: String)
    fun navigatePhone(phoneNumber: String)
    fun navigateMail(mail: String)
    fun navigateGithub(githubAddress: String)
    fun navigateLinkedIn(linkedInAddress: String)
}