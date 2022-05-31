package com.steve.twitterclone.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.steve.twitterclone.adapter.RvAdapter
import com.steve.twitterclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var tweetAdapter: RvAdapter

    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val tweets = homeViewModel.getData()
        tweetAdapter = RvAdapter(tweets)
        binding.rvTweet.apply {
            adapter = tweetAdapter
            addItemDecoration(
                DividerItemDecoration(
                    requireActivity(),
                    DividerItemDecoration.VERTICAL
                )
            )
            binding.rvTweet.scrollToPosition(homeViewModel.scrollPosition)

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    homeViewModel.scrollPosition = dy + dx
                }
            })
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        binding.rvTweet.scrollToPosition(homeViewModel.scrollPosition)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}