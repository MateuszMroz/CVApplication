package com.mroz.mateusz.cvapplication.ui.experience.adapter

import com.mroz.mateusz.cvapplication.ui.experience.model.Task
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class ExperienceGroup(title: String, listTasks: List<Task>) :
    ExpandableGroup<Task>(title, listTasks)