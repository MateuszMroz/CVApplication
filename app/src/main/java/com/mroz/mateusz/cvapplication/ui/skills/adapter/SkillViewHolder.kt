package com.mroz.mateusz.cvapplication.ui.skills.adapter

import android.view.View
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import kotlinx.android.synthetic.main.item_skill.view.*
import kotlinx.android.synthetic.main.subitem_skill.view.*


class SkillViewHolder(itemView: View) : GroupViewHolder(itemView) {
    init {
        itemView.arrow_skills_iv.setBackgroundResource(R.drawable.ic_arrow_drop_down_black)
    }

    fun setSkill(group: ExpandableGroup<SkillDetails>) {
        itemView.skill_tv.text = group.title
    }

    override fun expand() {
        super.expand()
        itemView.arrow_skills_iv.setBackgroundResource(R.drawable.ic_arrow_drop_up_black)
    }

    override fun collapse() {
        super.collapse()
        itemView.arrow_skills_iv.setBackgroundResource(R.drawable.ic_arrow_drop_down_black)
    }

    class SkillDetailsViewHolder(itemView: View) : ChildViewHolder(itemView) {
        fun onBind(skillDetails: SkillDetails) {
            itemView.skill_type_tv.text = skillDetails.skill
            try {
                itemView.skill_level_rb.rating = skillDetails.skillLevel
            } catch (e: NumberFormatException) {
                itemView.skill_level_rb.rating = 0f
            }
        }
    }
}