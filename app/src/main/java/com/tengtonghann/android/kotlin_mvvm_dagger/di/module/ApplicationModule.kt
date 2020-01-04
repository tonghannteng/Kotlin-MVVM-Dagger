package com.tengtonghann.android.kotlin_mvvm_dagger.di.module

import android.content.Context
import com.tengtonghann.android.kotlin_mvvm_dagger.BuildConfig
import com.tengtonghann.android.kotlin_mvvm_dagger.MyApplication
import com.tengtonghann.android.kotlin_mvvm_dagger.data.remote.NetworkService
import com.tengtonghann.android.kotlin_mvvm_dagger.data.remote.Networking
import com.tengtonghann.android.kotlin_mvvm_dagger.di.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 104 //10MB
        )
}