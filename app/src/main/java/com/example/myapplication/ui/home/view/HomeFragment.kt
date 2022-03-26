package com.example.myapplication.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.myapplication.NewsApplication
import com.example.myapplication.R
import com.example.myapplication.data.models.Articles
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.home.viewModel.HomeViewModel
import com.example.myapplication.ui.home.viewModel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel
    private lateinit var viewModelFactory: HomeViewModelFactory
    private val ArticleDetailCallback :(it:Articles)->Unit=  {it:Articles->
        val bundle = Bundle()
        bundle.putSerializable("article",it)
        Navigation.findNavController(binding.root).navigate(R.id.action_nav_home_to_details,bundle)
    }
    private val adapter = ArticleListAdapter(ArticleDetailCallback)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = HomeViewModelFactory((requireContext().applicationContext as NewsApplication).repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.articleList.adapter = adapter
        viewModel.articlesLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.articles = it
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLatestNews()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}