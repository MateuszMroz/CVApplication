package com.mroz.mateusz.cvapplication.ui.projects.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.projects.model.Project


class ProjectAdapter : RecyclerView.Adapter<ProjectViewHolder>() {
    var listProjects: MutableList<Project> = ArrayList()
        set(value) {
            loadProjects(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_projects, parent, false)
        return ProjectViewHolder(view)
    }

    override fun getItemCount(): Int =
        listProjects.size

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(listProjects[position])
    }

    private fun loadProjects(listProjects: List<Project>) {
        this.listProjects.clear()
        this.listProjects.addAll(listProjects)
        notifyDataSetChanged()
    }
}