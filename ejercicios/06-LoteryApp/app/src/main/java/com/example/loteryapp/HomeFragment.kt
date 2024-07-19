package com.example.loteryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.loteryapp.databinding.FragmentHomeBinding
import kotlin.random.Random

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.nextButton.setOnClickListener {
            val bundle = bundleOf("name" to binding.editTextText.text.toString(),
                "number" to generateLottoNumbersText(6))
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
        }
        return binding.root
    }

    private fun generateLottoNumbersText(totalNumbers: Int): String {
        var res = ""
        for (i in 0..totalNumbers) {
            res += Random.nextInt(0, 100).toString() + " "
        }
        return res.trim()
    }
}