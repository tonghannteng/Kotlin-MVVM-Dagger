package com.tengtonghann.android.kotlin_mvvm_dagger.di.component

import android.content.Context
import com.tengtonghann.android.kotlin_mvvm_dagger.MyApplication
import com.tengtonghann.android.kotlin_mvvm_dagger.data.remote.NetworkService
import com.tengtonghann.android.kotlin_mvvm_dagger.di.ApplicationContext
import com.tengtonghann.android.kotlin_mvvm_dagger.di.module.ApplicationModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getCompositeDisposable(): CompositeDisposable

    fun getNetworkService(): NetworkService
}