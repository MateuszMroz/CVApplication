package com.mroz.mateusz.cvapplication.di.module

import com.mroz.mateusz.cvapplication.ui.base_information.BaseInfoFragment
import com.mroz.mateusz.cvapplication.ui.education.EducationFragment
import com.mroz.mateusz.cvapplication.ui.experience.ExperienceFragment
import com.mroz.mateusz.cvapplication.ui.list_section.ListSectionFragment
import com.mroz.mateusz.cvapplication.ui.projects.ProjectsFragment
import com.mroz.mateusz.cvapplication.ui.skills.SkillsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeListSectionFragment(): ListSectionFragment

    @ContributesAndroidInjector
    abstract fun contributeBaseInfoFragment(): BaseInfoFragment

    @ContributesAndroidInjector
    abstract fun contributeEducationFragment(): EducationFragment

    @ContributesAndroidInjector
    abstract fun contributeExperienceFragment(): ExperienceFragment

    @ContributesAndroidInjector
    abstract fun contributeProjectsFragment(): ProjectsFragment

    @ContributesAndroidInjector
    abstract fun contributeSkillFragment(): SkillsFragment

}