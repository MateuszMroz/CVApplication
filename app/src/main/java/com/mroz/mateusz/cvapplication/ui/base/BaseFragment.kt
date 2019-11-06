package com.mroz.mateusz.cvapplication.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.di.Injectable
import com.mroz.mateusz.cvapplication.util.ProgressDialog

open class BaseFragment : Fragment(), Injectable {

    private val progressDialog = context?.let { ProgressDialog(it) }

    protected fun showError(message: String?, view: View) {
        Snackbar.make(
            view,
            message ?: getString(R.string.unknown_message), Snackbar.LENGTH_LONG
        ).show()
    }

    protected fun showLoader(message: String) {
        progressDialog?.show()
        progressDialog?.setInfo(message)
    }

    protected fun hideLoader() {
        progressDialog?.hide()
    }
}