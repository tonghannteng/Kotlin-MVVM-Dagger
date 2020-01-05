package com.tengtonghann.android.kotlin_mvvm_dagger.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tengtonghann.android.kotlin_mvvm_dagger.data.model.Movie
import com.tengtonghann.android.kotlin_mvvm_dagger.data.remote.NetworkService
import com.tengtonghann.android.kotlin_mvvm_dagger.di.ActivityScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: NetworkService
) {
    companion object {
        const val TAG = "MainViewModel"
    }

    val movies = MutableLiveData<List<Movie>>()

    fun getMovies() {
        compositeDisposable.add(
            networkService.doMovieGetCall()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        movies.postValue(it)
                    },
                    {
                        Log.d(TAG, it.toString())
                    }
                )
        )
    }
}