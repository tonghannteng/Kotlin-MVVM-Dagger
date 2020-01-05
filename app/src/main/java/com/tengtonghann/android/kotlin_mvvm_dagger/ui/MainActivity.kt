package com.tengtonghann.android.kotlin_mvvm_dagger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import com.tengtonghann.android.kotlin_mvvm_dagger.MyApplication
import com.tengtonghann.android.kotlin_mvvm_dagger.R
import com.tengtonghann.android.kotlin_mvvm_dagger.di.component.DaggerActivityComponent
import com.tengtonghann.android.kotlin_mvvm_dagger.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvData = findViewById<TextView>(R.id.text_main_activity)
        viewModel.movies.observe(this, Observer {
            tvData.text = it.toString()
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
