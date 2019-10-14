package com.sample.basicmvvmarchitecturesample.data.repositories

import androidx.lifecycle.LiveData
import com.sample.basicmvvmarchitecturesample.data.contracts.MovieListDataSource
import com.sample.basicmvvmarchitecturesample.data.models.Movie
import com.sample.basicmvvmarchitecturesample.data.sourcemock.DataSourceMovieMock
import javax.inject.Inject

class MovieRepository @Inject constructor(val mockDataSource: DataSourceMovieMock) :
    MovieListDataSource {

    override fun getMovies(): LiveData<MutableList<Movie>> {
        return mockDataSource.getMovies()
    }

}