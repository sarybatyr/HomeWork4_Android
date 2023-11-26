package com.example.hw4

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw4.databinding.FragmentFirstBinding

class FragmentFirst: Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(">>> FragmentFirst", "onCreateView")
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        Log.d(">>> FragmentFirst", "onViewCreated")
        binding.button.setOnClickListener{
            findNavController().navigate(FragmentFirstDirections.actionFragmentFirstToFragmentSecond())
        }
    }

}