package com.mroz.mateusz.cvapplication.ui.experience.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.experience.model.Task
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup


class ExperienceAdapter(groups: List<ExpandableGroup<*>>) :
    ExpandableRecyclerViewAdapter<ExperienceViewHolder, ExperienceViewHolder.TaskViewHolder>(groups) {

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): ExperienceViewHolder {
        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(view)
    }

    override fun onCreateChildViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): ExperienceViewHolder.TaskViewHolder {
        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.subitem_experience, parent, false)
        return ExperienceViewHolder.TaskViewHolder(view)
    }

    override fun onBindChildViewHolder(
        holder: ExperienceViewHolder.TaskViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?,
        childIndex: Int
    ) {
        val task = group?.items?.get(childIndex) as Task
        holder?.onBind(task)
    }

    override fun onBindGroupViewHolder(
        holder: ExperienceViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?
    ) {
        holder?.setExperience(group as ExpandableGroup<Task>)
    }
}