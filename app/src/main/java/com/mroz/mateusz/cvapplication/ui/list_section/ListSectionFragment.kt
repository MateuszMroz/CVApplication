package com.mroz.mateusz.cvapplication.ui.list_section

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.list_section.adapter.SectionAdapter
import com.mroz.mateusz.cvapplication.ui.list_section.model.SectionModel
import kotlinx.android.synthetic.main.fragment_list_section.*

class ListSectionFragment : BaseFragment(), ListSectionView {
    companion object {
        @JvmStatic
        fun newInstance() = ListSectionFragment()
    }

    lateinit var adapter: SectionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListSection()
    }

    override fun initializeListSection() {
        val listSection = mutableListOf<SectionModel>()
        for (section:String in resources.getStringArray(R.array.section_list)) {
            listSection.add(SectionModel(section))
        }
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = SectionAdapter(listSection, object: SectionAdapter.SectionInterface{
            override fun onSectionClick(section: SectionModel) {
                Toast.makeText(context, section.sectionTitle, Toast.LENGTH_LONG).show()
            }
        })
        section_list_rv.layoutManager = layoutManager
        section_list_rv.adapter = adapter
    }
}
