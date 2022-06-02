package com.example.myapplication.ui.movieDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.network.poster_path
import com.example.myapplication.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    val vm : DetailViewModel by viewModels()
    val args: DetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getMovieDetail(args.movieId).observe(viewLifecycleOwner){
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()

//            Glide.with(this)
//                .load(poster_path + it.poster_path)
//                .placeholder(R.drawable.loading)
//                .into(binding.poster)
            binding.movieTitle.text = getString(R.string.title) + it.title
            binding.releaseDate.text = "Release Date: "+ it.release_date
            binding.overview.text = "Overview: "+ it.overview
            binding.homePageAddress.text = "Home Page Address: "+ it.homepage
            binding.imageUrl= it.poster_path
//            binding.imageUrl= poster_path + vm.filmLD.value?.poster_path
        }


        binding.goToWebView.setOnClickListener {
            Toast.makeText(context, "show video", Toast.LENGTH_SHORT).show()
         var action = DetailFragmentDirections.actionDetailFragmentToShowVideoFragment(args.movieId)
            findNavController().navigate(action)
        }
    }
}