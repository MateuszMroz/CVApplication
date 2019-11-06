package com.mroz.mateusz.cvapplication.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.mroz.mateusz.cvapplication.R
import kotlinx.android.synthetic.main.dialog_please_wait.*

class ProgressDialog(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_please_wait)
        setCancelable(false)
        setCanceledOnTouchOutside(false)

        setInfo(context.getString(R.string.please_wait))
    }

    fun setInfo(info: String) {
        progress_info.text = info
    }
}