package com.example.assignment8.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assignment8.R
import com.example.assignment8.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using DataBindingUtil
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        // Get the character passed from the previous fragment via arguments
        val args = DetailFragmentArgs.fromBundle(requireArguments()).character

        // Create the ViewModel with the arguments
        val factory = DetailViewModelFactory(args)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        // Set the viewModel for DataBinding to use
        binding.viewModel = viewModel

        // Make sure the binding is aware of lifecycle changes
        binding.lifecycleOwner = this

        // Observe navigation changes
        viewModel.navigateToJson.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToJsonFragment())
                viewModel.doneNavigating()
            }
        })

        return binding.root
    }
}
