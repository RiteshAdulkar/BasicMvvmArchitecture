package com.sample.basicmvvmarchitecturesample.data.contracts

import androidx.lifecycle.LiveData
import com.sample.basicmvvmarchitecturesample.data.models.Movie

interface MovieListDataSource {

    fun getMovies(): LiveData<MutableList<Movie>>
}