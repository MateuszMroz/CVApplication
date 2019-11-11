package com.mroz.mateusz.cvapplication.ui.projects.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import kotlinx.android.synthetic.main.item_projects.view.*


class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(project: Project) {
        itemView.project_date_tv.text = project.time
        itemView.project_name_tv.text = project.name
        itemView.project_description_tv.text = project.description
    }
}