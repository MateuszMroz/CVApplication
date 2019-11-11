package com.mroz.mateusz.cvapplication.ui.experience


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.di.Injectable
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.experience.adapter.ExperienceAdapter
import com.mroz.mateusz.cvapplication.ui.experience.adapter.ExperienceGroup
import kotlinx.android.synthetic.main.fragment_experience.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ExperienceFragment : BaseFragment(), ExperienceView, Injectable {
    companion object {
        @JvmStatic
        fun newInstance() = ExperienceFragment()
    }

    override fun layout(): Int = R.layout.fragment_experience

    @Inject
    lateinit var presenter: ExperiencePresenter
    lateinit var adapter: ExperienceAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.loadExperience()
    }

    override fun loadExperienceList(listExperience: List<ExperienceGroup>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = ExperienceAdapter(listExperience)
        experience_rv.layoutManager = layoutManager
        experience_rv.adapter = adapter
    }

    override fun showLoader() {
        loaderOn()
    }

    override fun hideLoader() {
        loaderOff()
    }

    override fun showMessage(text: String) {
        message(text, experience_root)
    }
}
