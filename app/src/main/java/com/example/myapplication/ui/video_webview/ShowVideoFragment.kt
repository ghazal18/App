package com.example.myapplication.ui.video_webview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.data.network.YOUTUBE_KEY
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.webView.loadUrl("https://stackoverflow.com/questions/8803915/window-manager-bad-token-exception")
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.canGoBack()
        binding.webView.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action === MotionEvent.ACTION_UP && binding.webView.canGoBack()) {
                binding.webView.goBack()
                return@OnKeyListener true
            }
            false
        })


        vm.getVideo(args.movieId).observe(viewLifecycleOwner){
            Toast.makeText(context, it[0].key, Toast.LENGTH_SHORT).show()
            binding.webView.loadUrl(YOUTUBE_KEY+ it[0].key)
            //YOUTUBE_KEY+ it[0].key
            //"https://www.youtube.com/watch?v=JG8tl0I63JU"
        }

    }
}