package com.mroz.mateusz.cvapplication.ui.list_section.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.list_section.model.SectionModel
import java.util.ArrayList


class SectionAdapter(
    private val listSection: List<SectionModel>,
    private val sectionInterface: SectionInterface
): RecyclerView.Adapter<SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_section, parent, false)
        return SectionViewHolder(view, sectionInterface)
    }

    override fun getItemCount(): Int = listSection.size

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(listSection[position])
    }

    interface SectionInterface {
        fun onSectionClick(section: SectionModel)
    }
}