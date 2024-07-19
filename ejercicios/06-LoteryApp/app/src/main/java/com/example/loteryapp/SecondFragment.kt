package com.example.loteryapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.loteryapp.databinding.FragmentHomeBinding
import com.example.loteryapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        val name = requireArguments().getString("name")
        val number = requireArguments().getString("number")
        binding.numbersTextView.text = number

        binding.shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "I am $name my lotto number is: $number")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent)
        }
        return binding.root
    }
}