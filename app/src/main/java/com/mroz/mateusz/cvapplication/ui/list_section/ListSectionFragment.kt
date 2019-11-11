package com.mroz.mateusz.cvapplication.ui.list_section

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.di.Injectable
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.base_information.BaseInfoFragment
import com.mroz.mateusz.cvapplication.ui.education.EducationFragment
import com.mroz.mateusz.cvapplication.ui.experience.ExperienceFragment
import com.mroz.mateusz.cvapplication.ui.list_section.adapter.SectionAdapter
import com.mroz.mateusz.cvapplication.ui.list_section.model.SectionModel
import com.mroz.mateusz.cvapplication.ui.projects.ProjectsFragment
import com.mroz.mateusz.cvapplication.ui.skills.SkillsFragment
import kotlinx.android.synthetic.main.fragment_list_section.*
import javax.inject.Inject


class ListSectionFragment : BaseFragment(), ListSectionView, Injectable {
    companion object {
        @JvmStatic
        fun newInstance() = ListSectionFragment()
    }

    @Inject
    lateinit var presenter: ListSectionPresenter
    lateinit var adapter: SectionAdapter

    override fun layout(): Int =
        R.layout.fragment_list_section

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListSection()
    }

    override fun initializeListSection() {
        val listSection = mutableListOf<SectionModel>()
        for (section: String in resources.getStringArray(R.array.section_list)) {
            listSection.add(SectionModel(section))
        }
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = SectionAdapter(listSection, object : SectionAdapter.SectionInterface {
            override fun onSectionClick(section: SectionModel) {
                selectFragment(section)
            }
        })
        section_list_rv.layoutManager = layoutManager
        section_list_rv.adapter = adapter
    }

    override fun showLoader() {
        loaderOn()
    }

    override fun hideLoader() {
        loaderOff()
    }

    override fun showMessage(text: String) {
        message(text, root_layout)
    }

    private fun selectFragment(section: SectionModel) {
        when (section.sectionTitle) {
            getString(R.string.base_info) -> replaceFragment(BaseInfoFragment.newInstance())
            getString(R.string.experience) -> replaceFragment(ExperienceFragment.newInstance())
            getString(R.string.projects) -> replaceFragment(ProjectsFragment.newInstance())
            getString(R.string.skills) -> replaceFragment(SkillsFragment.newInstance())
            getString(R.string.education) -> replaceFragment(EducationFragment.newInstance())
            else -> showMessage(getString(R.string.canot_open_fragment))
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .addToBackStack(null)
            .commit()
    }

}
