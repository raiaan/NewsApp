package com.example.myapplication.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.models.Articles
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {
    private lateinit var detailsViewModel: DetailsViewModel
    private lateinit var binding: FragmentDetailsBinding
    private  var article:Articles? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article = requireArguments().getSerializable("article") as Articles
        init()
    }
    private fun init() {
        observeToHome()
        setUpUI()
    }

    private fun observeToHome() {
        detailsViewModel.navToHome.observe(viewLifecycleOwner, {
            it?.let { it1 ->
                if (it1) {
                    Navigation.findNavController(binding.root).popBackStack()
                }
            }
        })

    }

    private fun setUpUI() {
        if (article != null){
            binding.sourceNameTxt.text = article!!.source?.name
            binding.titleTxt.text = article!!.title
            binding.descriptionTxt.text = article!!.description
            Picasso.get().load(article!!.urlToImage)
                .into(binding.img)
            binding.backToNews.setOnClickListener({
                detailsViewModel.navToHome()
            })
        }
    }
}