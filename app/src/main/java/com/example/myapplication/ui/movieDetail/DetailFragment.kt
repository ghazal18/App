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
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getMovieDetail(args.movieId).observe(viewLifecycleOwner){
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            Glide.with(this).load(poster_path + it.poster_path).into(binding.poster)
            binding.movieTitle.text = it.title
        }

        binding.goToWebView.setOnClickListener {
            Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show()
         var action = DetailFragmentDirections.actionDetailFragmentToShowVideoFragment(args.movieId)
            findNavController().navigate(action)
        }
    }
}