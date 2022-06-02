package com.example.myapplication.ui.movieList

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.network.ApiService
import com.example.myapplication.data.network.poster_path
import com.example.myapplication.databinding.FragmentMovieListBinding
import com.example.myapplication.model.Movie
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieListFragment : Fragment() {
    lateinit var binding: FragmentMovieListBinding
    val viewModel : MovieListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_movie_list,container,false)
        binding.vModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MovieAdapter{movieClick(it)}
        binding.movieRecyclerView.adapter = adapter
        binding.searchIcon.setOnClickListener {
            var action = MovieListFragmentDirections.actionMovieListFragmentToSearchResultFragment(binding.searchBox.text.toString())
            findNavController().navigate(action)
        }
        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
//            Glide.with(this).load(poster_path + it[0].poster_path).into(binding.moviePhoto)
        }

    }

    fun movieClick(film:Movie){

        var action = MovieListFragmentDirections.actionMovieListFragmentToDetailFragment(film.id)
//        Toast.makeText(context, film.title, Toast.LENGTH_SHORT).show()
        findNavController().navigate(action)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.upComingMovieList ->{
            findNavController().navigate(R.id.action_movieListFragment_to_upComingMovieFragment)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //    https://image.tmdb.org/p/w500//neMZH82Stu91d3iqvLdNQfqPPyl.jpg
//    https://image.tmdb.org/t/p/w500/neMZH82Stu91d3iqvLdNQfqPPyl.jpg


}