package com.mroz.mateusz.cvapplication.ui.skills


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.di.Injectable
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillAdapter
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import kotlinx.android.synthetic.main.fragment_skills.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SkillsFragment : BaseFragment(), SkillsView, Injectable {
    companion object {
        @JvmStatic
        fun newInstance() = SkillsFragment()
    }

    override fun layout(): Int = R.layout.fragment_skills

    @Inject
    lateinit var presenter: SkillsPresenter
    var adapter: SkillAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.loadSkills()
    }

    override fun showLoader() {
        loaderOn()
    }

    override fun hideLoader() {
        loaderOff()
    }

    override fun showMessage(text: String) {
        message(text, skills_root)
    }

    override fun loadSkillList(listSkills: List<SkillsGroup>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = SkillAdapter(listSkills)
        skills_rv.layoutManager = layoutManager
        skills_rv.adapter = adapter
    }
}
