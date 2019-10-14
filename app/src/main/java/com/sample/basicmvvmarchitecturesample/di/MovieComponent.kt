package com.sample.basicmvvmarchitecturesample.di

import com.sample.basicmvvmarchitecturesample.data.view.activity.MovieListActivity
import dagger.Component
import javax.inject.Singleton

/**
 * The Module class doesn’t provide the dependency directly to the class
 * that’s requesting it. For this, a Component interface is used that
 * acts as a bridge between @Module and @Inject.
 */
@Singleton
@Component(modules = [RepositoryModule::class])
interface MovieComponent {
    fun inject(activity: MovieListActivity)
}