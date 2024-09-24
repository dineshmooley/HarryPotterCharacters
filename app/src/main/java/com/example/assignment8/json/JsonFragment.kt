package com.example.assignment8.json

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
import com.example.assignment8.databinding.FragmentJsonBinding
import kotlin.random.Random

class JsonFragment : Fragment() {
    private lateinit var binding: FragmentJsonBinding
    private lateinit var viewModel: JsonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_json, container, false)
        viewModel = ViewModelProvider(this)[JsonViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.properties.observe(viewLifecycleOwner, Observer   {
            if(it != null)  {
                viewModel.setCharacter()
            }
        })

        viewModel.navigateToImage.observe(viewLifecycleOwner, Observer  {
            if(it)  {
                val rand = Random.nextInt(25)
                findNavController().navigate(JsonFragmentDirections.actionJsonFragmentToDetailFragment(viewModel.character[rand]))
                viewModel.doneNavigating()
            }
        })

        return binding.root
    }
}
