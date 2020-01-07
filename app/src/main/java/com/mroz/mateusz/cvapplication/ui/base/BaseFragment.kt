package com.mroz.mateusz.cvapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import kotlinx.android.synthetic.main.please_wait_information.*


abstract class BaseFragment : Fragment(), BaseView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int = layout()
        return inflater.inflate(layout, container, false)
    }

    abstract fun layout(): Int

    override fun message(message: String?, view: View) {
        Snackbar.make(
            view,
            message ?: getString(R.string.unknown_message), Snackbar.LENGTH_LONG
        ).show()
    }

    override fun loaderOn() {
        loading_state?.let {
            loading_state.visibility = View.VISIBLE
        }
    }

    override fun loaderOff() {
        loading_state?.let {
            it.visibility = View.GONE
        }
    }
}