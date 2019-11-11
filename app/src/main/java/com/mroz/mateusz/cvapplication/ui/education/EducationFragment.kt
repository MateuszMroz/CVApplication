package com.mroz.mateusz.cvapplication.ui.education


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.di.Injectable
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.education.adapter.EducationAdapter
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import kotlinx.android.synthetic.main.fragment_education.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class EducationFragment : BaseFragment(), EducationView, Injectable {
    companion object {
        @JvmStatic
        fun newInstance() = EducationFragment()
    }

    override fun layout(): Int = R.layout.fragment_education

    @Inject
    lateinit var presenter: EducationPresenter
    private lateinit var adapter: EducationAdapter

    private fun initializeRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = EducationAdapter()
        education_rv.layoutManager = layoutManager
        education_rv.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        presenter.view = this
        presenter.loadEducationPosition()
    }

    override fun showLoader() {
        loaderOn()
    }

    override fun hideLoader() {
        loaderOff()
    }

    override fun showMessage(text: String) {
        message(text, education_root)
    }

    override fun updateAdapter(listEducationPosition: List<Education>) {
        adapter.listEducationPosition = listEducationPosition as MutableList<Education>
    }
}
