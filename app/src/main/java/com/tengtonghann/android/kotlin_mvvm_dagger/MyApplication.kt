package com.tengtonghann.android.kotlin_mvvm_dagger

import android.app.Application
import com.tengtonghann.android.kotlin_mvvm_dagger.data.remote.NetworkService
import com.tengtonghann.android.kotlin_mvvm_dagger.di.component.ApplicationComponent
import com.tengtonghann.android.kotlin_mvvm_dagger.di.component.DaggerApplicationComponent
import com.tengtonghann.android.kotlin_mvvm_dagger.di.module.ApplicationModule
import javax.inject.Inject

class MyApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var networkService: NetworkService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)
    }

}