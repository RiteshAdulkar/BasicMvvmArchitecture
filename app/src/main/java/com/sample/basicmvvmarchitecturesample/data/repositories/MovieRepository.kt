package com.sample.basicmvvmarchitecturesample.data.repositories

import androidx.lifecycle.LiveData
import com.sample.basicmvvmarchitecturesample.data.contracts.MovieListDataSource
import com.sample.basicmvvmarchitecturesample.data.models.Movie
import com.sample.basicmvvmarchitecturesample.data.sourcemock.DataSourceMovieMock

class MovieRepository(mockDataSource: DataSourceMovieMock) : MovieListDataSource {

    var dataSource: MovieListDataSource = mockDataSource

    override fun getMovies(): LiveData<MutableList<Movie>> {
        return dataSource.getMovies()
    }

}