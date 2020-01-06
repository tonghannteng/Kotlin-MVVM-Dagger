package com.tengtonghann.android.kotlin_mvvm_dagger.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tengtonghann.android.kotlin_mvvm_dagger.MyApplication
import com.tengtonghann.android.kotlin_mvvm_dagger.R
import com.tengtonghann.android.kotlin_mvvm_dagger.di.component.DaggerActivityComponent
import com.tengtonghann.android.kotlin_mvvm_dagger.di.module.ActivityModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.movies.observe(this, Observer { movies ->
            rv_main_activity.also {
                it.layoutManager = LinearLayoutManager(baseContext)
                it.setHasFixedSize(true)
                it.adapter = MovieAdapter(movies)
            }
        })
        viewModel.getMovies()
    }

    private fun getDependencies() {
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}
