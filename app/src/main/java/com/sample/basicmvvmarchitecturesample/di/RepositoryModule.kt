package com.sample.basicmvvmarchitecturesample.di

import com.sample.basicmvvmarchitecturesample.data.sourcemock.DataSourceMovieMock
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Module This is used on the class that does the work
 * of constructing objects that’ll be eventually provided as dependencies.
 * @Provides This is used on the methods inside the Module class
 * that’ll return the object.
 * @Singleton This indicates that only a single instance of the dependency
 * object would be created.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    internal fun provideMockMovieRepo(): DataSourceMovieMock {
        return DataSourceMovieMock()
    }

}