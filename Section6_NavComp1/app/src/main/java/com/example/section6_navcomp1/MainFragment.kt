package com.example.section6_navcomp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.section6_navcomp1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.termsButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_termsFragment)
        }
        binding.singnupButton.setOnClickListener { it.findNavController().navigate(R.id.action_mainFragment_to_userInputFragment) }
        return binding.root
    }

}