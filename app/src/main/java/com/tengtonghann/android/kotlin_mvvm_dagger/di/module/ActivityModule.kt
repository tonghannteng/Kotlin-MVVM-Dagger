package com.tengtonghann.android.kotlin_mvvm_dagger.di.module

import android.app.Activity
import android.content.Context
import com.tengtonghann.android.kotlin_mvvm_dagger.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity
}