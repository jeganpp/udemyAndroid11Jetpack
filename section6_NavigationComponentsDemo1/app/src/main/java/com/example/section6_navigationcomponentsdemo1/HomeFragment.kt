package com.example.section6_navigationcomponentsdemo1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.section6_navigationcomponentsdemo1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {
            button.setOnClickListener {
                if(!TextUtils.isEmpty(binding.editTextTextPersonName.text.toString())) {
                    val bundle: Bundle =
                        bundleOf("userInput" to binding.editTextTextPersonName.text.toString())
                    it.findNavController()
                        .navigate(R.id.action_homeFragment_to_secondFragment, bundle)
                } else {
                    Toast.makeText(activity,"pls enter your name", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
    }
}