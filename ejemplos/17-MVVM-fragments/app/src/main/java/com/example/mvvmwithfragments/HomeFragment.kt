package com.example.mvvmwithfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmwithfragments.databinding.FragmentHomeBinding
import com.example.mvvmwithfragments.viewmodels.ContactShareViewModel

class HomeFragment : Fragment(R.layout.fragment_home) { // The R.layout to use this other binding type
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: ContactShareViewModel
    lateinit var adapter: ContactsRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Replaces this: binding  = DataBindingUtil.inflate(inflater, R.layout.homeFragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).contactViewModel
        viewModel.getAllContacts()
        setupRecyclerView()
        setupAddButton()
    }

    private fun setupAddButton() {
        binding.floatingActionButton.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment() // You can sent param here.
            binding.root.findNavController().navigate(direction)
        }
    }

    private fun setupRecyclerView() {
        adapter = ContactsRecyclerViewAdapter(listOf()) { contact ->
            viewModel.selectContact(contact)
            // redirect to detail fragments
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment() // You can sent param here.
            binding.root.findNavController().navigate(direction)
        }

        val ownerContext = (activity as MainActivity)
        binding.recyclerView.layoutManager = LinearLayoutManager(ownerContext, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        activity.let {// if (activity != null) { do something}
            viewModel.contacts.observe(viewLifecycleOwner) {contacts ->
                adapter.contacts = contacts
                adapter.notifyDataSetChanged()
            }
        }
    }
}