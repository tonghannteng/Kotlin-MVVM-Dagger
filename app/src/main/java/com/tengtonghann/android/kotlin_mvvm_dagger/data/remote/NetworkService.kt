package com.tengtonghann.android.kotlin_mvvm_dagger.data.remote

import com.tengtonghann.android.kotlin_mvvm_dagger.data.model.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkService {

    @GET(Endpoints.MOVIES)
    fun doMovieGetCall(): Single<List<Movie>>
}