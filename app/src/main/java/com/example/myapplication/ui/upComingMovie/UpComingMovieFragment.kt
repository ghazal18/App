package com.example.myapplication.ui.upComingMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUpComingMovieBinding
import com.example.myapplication.ui.movieList.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UpComingMovieFragment : Fragment() {
    lateinit var binding: FragmentUpComingMovieBinding
    val vModel: UpComingMovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_up_coming_movie,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = UpComingResultRecyclerAdapter()
        binding.upcomingRecycler.adapter = adapter

        vModel.upComingMovieListLD.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }
}
