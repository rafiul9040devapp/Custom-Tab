package com.walletmix.custometab.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.walletmix.custometab.R
import com.walletmix.custometab.databinding.FragmentFridayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FridayFragment : Fragment() {
    private lateinit var binding: FragmentFridayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFridayBinding.inflate(inflater, container, false)
        return binding.root
    }
}