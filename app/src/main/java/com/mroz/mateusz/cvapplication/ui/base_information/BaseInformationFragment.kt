package com.mroz.mateusz.cvapplication.ui.base_information


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mroz.mateusz.cvapplication.R

/**
 * A simple [Fragment] subclass.
 */
class BaseInformationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_information, container, false)
    }


}
