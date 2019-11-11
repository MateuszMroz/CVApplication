package com.mroz.mateusz.cvapplication.ui.projects


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.di.Injectable
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.projects.adapter.ProjectAdapter
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import kotlinx.android.synthetic.main.fragment_projects.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ProjectsFragment : BaseFragment(), ProjectsView, Injectable {
    companion object {
        @JvmStatic
        fun newInstance() = ProjectsFragment()
    }

    @Inject
    lateinit var presenter: ProjectsPresenter
    lateinit var adapter: ProjectAdapter

    override fun layout(): Int = R.layout.fragment_projects

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        initializeProjectList()
        presenter.loadProjects()
    }

    private fun initializeProjectList() {
        val layoutManager = LinearLayoutManager(context)
        adapter = ProjectAdapter()
        projects_rv.layoutManager = layoutManager
        projects_rv.adapter = adapter
    }

    override fun showLoader() {
        loaderOn()
    }

    override fun hideLoader() {
        loaderOff()
    }

    override fun showMessage(text: String) {
        message(text, projects_root)
    }

    override fun updateAdapter(listProjects: List<Project>) {
        adapter.listProjects = listProjects as MutableList<Project>
    }


}
