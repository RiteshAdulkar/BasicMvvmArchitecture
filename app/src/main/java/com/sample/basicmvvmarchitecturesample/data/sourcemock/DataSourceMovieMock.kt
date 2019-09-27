package com.sample.basicmvvmarchitecturesample.data.sourcemock

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.basicmvvmarchitecturesample.data.contracts.MovieListDataSource
import com.sample.basicmvvmarchitecturesample.data.models.Movie
import com.sample.basicmvvmarchitecturesample.mockgenerator.MockGenerator
import android.content.Context.CONNECTIVITY_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import com.google.gson.Gson


/**
 * Mock data source class to get data from @MockGenerator
 */
open class DataSourceMovieMock : MovieListDataSource {

    private val movieListLiveData = MutableLiveData<MutableList<Movie>>()
    lateinit var isLoader: MutableLiveData<Boolean>

    override fun getMovies(): LiveData<MutableList<Movie>> {
        movieListLiveData.value = MockGenerator.getMovies()
        val data = Gson().toJson(MockGenerator.getMovies())

        return movieListLiveData
    }
}