package com.example.myapplication.ui.search_result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSearchResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchResultFragment : Fragment() {
    lateinit var binding: FragmentSearchResultBinding
    val vModel: SearchResultViewModel by viewModel()
    val args: SearchResultFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_result,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SearchResultAdapter()


        vModel.searchMovieList(args.searchWord).observe(viewLifecycleOwner){
            binding.searchRecyclerView.adapter = adapter
            adapter.submitList(it)
        }
    }
}