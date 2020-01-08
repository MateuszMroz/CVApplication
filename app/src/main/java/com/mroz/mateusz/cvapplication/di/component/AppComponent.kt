package com.mroz.mateusz.cvapplication.di.component

import android.app.Application
import com.mroz.mateusz.cvapplication.CVApplication
import com.mroz.mateusz.cvapplication.di.ViewModelFactoryModule
import com.mroz.mateusz.cvapplication.di.details.DetailViewModelModules
import com.mroz.mateusz.cvapplication.di.module.AppModule
import com.mroz.mateusz.cvapplication.di.module.ActivityBuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        ActivityBuildersModule::class,
        /*temporary for check*/
        DetailViewModelModules::class]
)
interface AppComponent : AndroidInjector<CVApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}