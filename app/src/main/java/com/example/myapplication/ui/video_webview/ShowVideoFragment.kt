package com.example.myapplication.ui.video_webview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentShowVideoBinding


class ShowVideoFragment : Fragment() {
    lateinit var binding:FragmentShowVideoBinding
    val vm: ShowVideoViewModel by viewModels()
    val args: ShowVideoFragmentArgs  by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_show_video,container,false)
        return inflater.inflate(R.layout.fragment_show_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.getVideo(args.movieId).observe(viewLifecycleOwner){

        }

    }
}