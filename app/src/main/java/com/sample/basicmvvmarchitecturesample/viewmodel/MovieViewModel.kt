package com.sample.basicmvvmarchitecturesample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.basicmvvmarchitecturesample.data.contracts.MovieListDataSource
import com.sample.basicmvvmarchitecturesample.data.models.Movie
import com.sample.basicmvvmarchitecturesample.data.repositories.MovieRepository

class MovieViewModel : ViewModel() {
    lateinit var repository: MovieRepository

    fun getMovieList(): LiveData<MutableList<Movie>> {
        return repository.getMovies()
    }

}