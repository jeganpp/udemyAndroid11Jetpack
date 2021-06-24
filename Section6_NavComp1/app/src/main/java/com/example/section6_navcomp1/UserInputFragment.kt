package com.example.section6_navcomp1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.section6_navcomp1.databinding.FragmentUserInputBinding

class UserInputFragment : Fragment() {
    private lateinit var binding: FragmentUserInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_input, container, false)
        binding.submitButton.setOnClickListener {
            val bundle: Bundle = bundleOf("name" to binding.userNameEditText.text.toString())
            it.findNavController().navigate(R.id.action_userInputFragment_to_welcomeFragment, bundle)
        }
        return binding.root
    }
}