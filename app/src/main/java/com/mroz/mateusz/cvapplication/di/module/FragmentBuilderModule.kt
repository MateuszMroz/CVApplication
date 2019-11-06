package com.mroz.mateusz.cvapplication.di.module

import com.mroz.mateusz.cvapplication.ui.list_section.ListSectionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeEpisodeFragment(): ListSectionFragment
}