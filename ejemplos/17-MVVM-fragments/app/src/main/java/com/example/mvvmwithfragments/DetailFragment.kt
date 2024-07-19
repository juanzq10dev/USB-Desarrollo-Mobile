package com.example.mvvmwithfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mvvmwithfragments.databinding.FragmentDetailBinding
import com.example.mvvmwithfragments.viewmodels.ContactDetailViewModel
import com.example.mvvmwithfragments.viewmodels.ContactShareViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {
    lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: ContactShareViewModel
    lateinit var detailViewModel: ContactDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).contactViewModel
        detailViewModel = (activity as MainActivity).contactDetailsViewModel
        binding.viewModel = viewModel
        binding.detailsViewModel = detailViewModel
        detailViewModel.updateTexts()
        binding.lifecycleOwner = this
        binding.button2.setOnClickListener {
            detailViewModel.save()
            binding.root.findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }
}