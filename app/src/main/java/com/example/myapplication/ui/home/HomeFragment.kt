package com.example.myapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.NewsApplication
import com.example.myapplication.data.models.Repository
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.home.viewModel.HomeViewModel
import com.example.myapplication.ui.home.viewModel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var  viewModel: HomeViewModel
    private lateinit var  repository:Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository= ((requireContext().applicationContext as NewsApplication).repository)
        viewModel = ViewModelProvider(this, HomeViewModelFactory(repository))[HomeViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel.mutableLiveData.observe(viewLifecycleOwner) {
            Log.v("connected", it.articles.get(0).title);
        }
        viewModel.getLatestNews()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}