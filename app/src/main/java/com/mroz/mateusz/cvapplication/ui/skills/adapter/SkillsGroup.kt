package com.mroz.mateusz.cvapplication.ui.skills.adapter

import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup


class SkillsGroup(title: String, listSkills: List<SkillDetails>):
    ExpandableGroup<SkillDetails>(title, listSkills)