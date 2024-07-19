package com.example.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.jetpacknavigation.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    lateinit var binding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        binding.button.setOnClickListener {
            val bundle = bundleOf("value" to binding.editTextText.text.toString())
            it.findNavController().navigate(R.id.action_blankFragment2_to_blankFragment22, bundle)
        }
        return binding.root
    }
}