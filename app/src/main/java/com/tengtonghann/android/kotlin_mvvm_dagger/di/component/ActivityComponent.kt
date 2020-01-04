package com.tengtonghann.android.kotlin_mvvm_dagger.di.component

import com.tengtonghann.android.kotlin_mvvm_dagger.di.ActivityScope
import com.tengtonghann.android.kotlin_mvvm_dagger.di.module.ActivityModule
import com.tengtonghann.android.kotlin_mvvm_dagger.ui.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}