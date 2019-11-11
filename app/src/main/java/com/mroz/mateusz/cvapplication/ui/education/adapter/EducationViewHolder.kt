package com.mroz.mateusz.cvapplication.ui.education.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import kotlinx.android.synthetic.main.item_education.view.*

class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(education:Education) {
        itemView.year_tv.text = education.data
        itemView.education_desc_tv.text = education.description
    }
}