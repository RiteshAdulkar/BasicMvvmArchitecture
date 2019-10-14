package com.sample.basicmvvmarchitecturesample

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.sample.basicmvvmarchitecturesample.di.DaggerMovieComponent
import com.sample.basicmvvmarchitecturesample.di.MovieComponent
import com.sample.basicmvvmarchitecturesample.di.RepositoryModule

class BaseApp : Application() {
    lateinit var movieComponent: MovieComponent

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        movieComponent = DaggerMovieComponent.builder().repositoryModule(RepositoryModule()).build()
    }

}