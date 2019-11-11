package com.mroz.mateusz.cvapplication.ui.skills.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup


class SkillAdapter(groups: List<SkillsGroup>):
    ExpandableRecyclerViewAdapter<SkillViewHolder, SkillViewHolder.SkillDetailsViewHolder>(groups) {

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_skill, parent, false)
        return SkillViewHolder(view)
    }

    override fun onCreateChildViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): SkillViewHolder.SkillDetailsViewHolder {
        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.subitem_skill, parent, false)
        return SkillViewHolder.SkillDetailsViewHolder(view)
    }

    override fun onBindChildViewHolder(
        holder: SkillViewHolder.SkillDetailsViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?,
        childIndex: Int
    ) {
        val skill = group?.items?.get(childIndex) as SkillDetails
        holder?.onBind(skill)
    }

    override fun onBindGroupViewHolder(
        holder: SkillViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?
    ) {
        holder?.setSkill(group as ExpandableGroup<SkillDetails>)
    }


}