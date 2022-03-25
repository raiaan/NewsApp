package com.example.myapplication.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.models.Articles
import com.example.myapplication.data.models.Repository
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.home.viewModel.HomeViewModel
import com.example.myapplication.ui.home.viewModel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var  viewModel: HomeViewModel
    private lateinit var  repository:Repository
    private val adapter = ArticleListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository= Repository(requireContext())
        viewModel = ViewModelProvider(this, HomeViewModelFactory(repository))[HomeViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.articleList.adapter = adapter
        viewModel.mutableLiveData.observe(viewLifecycleOwner) {
            adapter.articles = it.articles
        }
        viewModel.getLatestNews()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}