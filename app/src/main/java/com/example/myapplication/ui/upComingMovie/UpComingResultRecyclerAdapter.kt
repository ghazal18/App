package com.example.myapplication.ui.upComingMovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.UpComingListItemBinding
import com.example.myapplication.model.Movie
import com.example.myapplication.model.UpComingResult

class UpComingResultRecyclerAdapter: ListAdapter<UpComingResult, UpComingResultRecyclerAdapter.ItemHolder>(UpcomingMovieDiffCallback) {

    class ItemHolder(val binding: UpComingListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding: UpComingListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.up_coming_list_item,
            parent,false
        )
        return ItemHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val movie = getItem(position)
        holder.binding.movie = movie
        holder.binding.imageUrl = getItem(position).poster_path

    }
}
    object UpcomingMovieDiffCallback : DiffUtil.ItemCallback<UpComingResult>() {

        override fun areItemsTheSame(oldItem: UpComingResult, newItem:UpComingResult): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UpComingResult, newItem: UpComingResult): Boolean {
            return oldItem.id == newItem.id
        }
}