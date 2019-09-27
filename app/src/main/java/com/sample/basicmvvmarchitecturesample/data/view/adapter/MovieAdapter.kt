package com.sample.basicmvvmarchitecturesample.data.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.sample.basicmvvmarchitecturesample.R
import com.sample.basicmvvmarchitecturesample.data.models.Movie

class MovieAdapter(private val movies: MutableList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie_list, parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.nameTextView.text = movie.name
        holder.descriptionTextView.text = movie.description
        holder.ratingTextView.text =
            holder.itemView.context.getString(R.string.rating, movie.rating)
        val uri = Uri.parse(movie.image)
        // Log.v("image uri $uri", "")
        holder.imageView.setImageURI(uri)
    }

    fun clearList() {
        movies?.clear()
        notifyDataSetChanged()
    }

    fun addAll(objects: MutableList<Movie>) {
        // to make notify efficient
        val to = movies?.size
        movies?.addAll(objects)
        if (to == 0) {
            notifyDataSetChanged()
            return
        }
        notifyItemRangeChanged(to, objects.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: SimpleDraweeView = itemView.findViewById(R.id.image_view)
        val nameTextView: TextView = itemView.findViewById(R.id.text_view_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.text_view_subtitle)
        val ratingTextView: TextView = itemView.findViewById(R.id.text_view_rating)

    }
}