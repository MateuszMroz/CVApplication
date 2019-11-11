package com.mroz.mateusz.cvapplication.ui.education.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.education.model.Education


class EducationAdapter : RecyclerView.Adapter<EducationViewHolder>() {

    var listEducationPosition: MutableList<Education> = ArrayList()
        set(value) {
            setEducationList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
        return EducationViewHolder(view)
    }

    override fun getItemCount(): Int =
        listEducationPosition.size

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.bind(listEducationPosition[position])
    }

    private fun setEducationList(listEducationPosition: List<Education>) {
        this.listEducationPosition.clear()
        this.listEducationPosition.addAll(listEducationPosition)
        notifyDataSetChanged()
    }

}