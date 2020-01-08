package com.mroz.mateusz.cvapplication.ui.projects


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.projects.adapter.ProjectAdapter
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_projects.*
import kotlinx.android.synthetic.main.fragment_projects.loading_state
import kotlinx.android.synthetic.main.fragment_skills.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ProjectsFragment : DaggerFragment(), ProjectsView {
    companion object {
        @JvmStatic
        fun newInstance() = ProjectsFragment()
    }

    @Inject
    lateinit var presenter: ProjectsPresenter
    lateinit var adapter: ProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int = R.layout.fragment_projects
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        initializeProjectList()
        //presenter.loadProjects()
    }

    private fun initializeProjectList() {
        val layoutManager = LinearLayoutManager(context)
        adapter = ProjectAdapter()
        projects_rv.layoutManager = layoutManager
        projects_rv.adapter = adapter
    }

    override fun showLoader() {
        CoroutineScope(Dispatchers.Main).launch {
            loading_state?.let {
                loading_state.visibility = View.VISIBLE
            }
        }
    }

    override fun hideLoader() {
        CoroutineScope(Dispatchers.Main).launch {
            loading_state?.let {
                it.visibility = View.GONE
            }
        }
    }

    override fun showMessage(text: String) {
        CoroutineScope(Dispatchers.Main).launch {
            Snackbar.make(
                skills_root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun updateAdapter(listProjects: List<Project>) {
        adapter.listProjects = listProjects as MutableList<Project>
    }


}
