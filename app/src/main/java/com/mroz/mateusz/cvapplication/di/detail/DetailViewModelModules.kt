package com.mroz.mateusz.cvapplication.di.detail

import androidx.lifecycle.ViewModel
import com.mroz.mateusz.cvapplication.di.ViewModelKey
import com.mroz.mateusz.cvapplication.ui.skills.SkillsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailViewModelModules {
    @Binds
    @IntoMap
    @ViewModelKey(SkillsViewModel::class)
    abstract fun bindSkillsViewModel(viewModel: SkillsViewModel): ViewModel
}