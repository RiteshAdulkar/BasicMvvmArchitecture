package com.sample.basicmvvmarchitecturesample.data.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.basicmvvmarchitecturesample.R
import com.sample.basicmvvmarchitecturesample.data.models.Movie
import com.sample.basicmvvmarchitecturesample.data.repositories.MovieRepository
import com.sample.basicmvvmarchitecturesample.data.sourcemock.DataSourceMovieMock
import com.sample.basicmvvmarchitecturesample.data.view.adapter.MovieAdapter
import com.sample.basicmvvmarchitecturesample.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

open class MovieListActivity : AppCompatActivity() {
    lateinit var viewModel: MovieViewModel
    private var toolbar: Toolbar? = null
    private var movieAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        super_recycler_view?.setLayoutManager(
            LinearLayoutManager(
                this,
                RecyclerView.VERTICAL, false
            )
        )
        super_recycler_view.setRefreshListener {
            viewModel.getMovieList().observe(this, Observer { response ->
                handleMovieListResponse(response)
            })
        }
        initViewModel()
    }

    private fun initToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeButtonEnabled(true)
        } else {
            Log.e(MovieListActivity::class.java.simpleName, "Action bar is null")
        }
    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.repository = MovieRepository(DataSourceMovieMock())
        viewModel.getMovieList().observe(this, Observer { response ->
            handleMovieListResponse(response)
        })
    }

    private fun handleMovieListResponse(response: MutableList<Movie>?) {
        super_recycler_view.setRefreshing(false)
        super_recycler_view.hideProgress()
        if (response == null) {
            return
        }
        if (movieAdapter == null) {
            movieAdapter = MovieAdapter(response)
        } else {
            movieAdapter?.clearList()
            movieAdapter?.addAll(response)
        }
        super_recycler_view.adapter = movieAdapter
    }

}