package com.example.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jetpacknavigation.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {
    lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.second_fragment, container, false)
        val textFromOtherFragment = requireArguments().getString("value")
        binding.secondText.text = textFromOtherFragment
        return binding.root
    }
}