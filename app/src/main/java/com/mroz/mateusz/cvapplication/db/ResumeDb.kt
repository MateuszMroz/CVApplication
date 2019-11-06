package com.mroz.mateusz.cvapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import com.mroz.mateusz.cvapplication.ui.experience.model.Experience
import com.mroz.mateusz.cvapplication.ui.experience.model.Task
import com.mroz.mateusz.cvapplication.ui.list_section.model.About
import com.mroz.mateusz.cvapplication.ui.projects.model.Project
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillValue

@Database(
    entities = [
        BaseInfo::class,
        Education::class,
        Experience::class,
        About::class,
        Project::class,
        Skill::class,
        SkillValue::class,
        Task::class],
    version = 1,
    exportSchema = false
)
abstract class ResumeDb: RoomDatabase() {
    abstract fun resumeDao() : ResumeDao
}