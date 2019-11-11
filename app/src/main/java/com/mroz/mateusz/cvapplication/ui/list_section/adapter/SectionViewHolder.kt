package com.mroz.mateusz.cvapplication.ui.list_section.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.ui.list_section.model.SectionModel
import kotlinx.android.synthetic.main.item_section.view.*


class SectionViewHolder(itemView: View, sectionInterface: SectionAdapter.SectionInterface) :
    RecyclerView.ViewHolder(itemView) {
    lateinit var sectionModel: SectionModel

    init {
        itemView.setOnClickListener {
            sectionInterface.onSectionClick(sectionModel)
        }
    }

    fun bind(section: SectionModel) {
        this.sectionModel = section
        itemView.section_title_tv.text = section.sectionTitle
    }
}