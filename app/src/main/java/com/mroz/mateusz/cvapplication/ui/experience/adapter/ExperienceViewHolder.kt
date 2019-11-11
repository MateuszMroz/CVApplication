package com.mroz.mateusz.cvapplication.ui.experience.adapter

import android.view.View
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.experience.model.Task
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import kotlinx.android.synthetic.main.item_experience.view.*
import kotlinx.android.synthetic.main.subitem_experience.view.*


class ExperienceViewHolder(itemView: View) : GroupViewHolder(itemView) {
    init {
        itemView.arrow_experience_iv.setBackgroundResource(R.drawable.ic_arrow_drop_down_black)
    }

    fun setExperience(group: ExpandableGroup<Task>) {
        itemView.info_work_tv.text = group.title
    }

    override fun expand() {
        super.expand()
        itemView.arrow_experience_iv.setBackgroundResource(R.drawable.ic_arrow_drop_up_black)
    }

    override fun collapse() {
        super.collapse()
        itemView.arrow_experience_iv.setBackgroundResource(R.drawable.ic_arrow_drop_down_black)
    }

    class TaskViewHolder(itemView: View) : ChildViewHolder(itemView) {
        fun onBind(task: Task) {
            itemView.task_tv.text = task.taskName
        }
    }
}