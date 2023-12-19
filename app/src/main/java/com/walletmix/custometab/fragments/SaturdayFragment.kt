package com.walletmix.custometab.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.walletmix.custometab.R
import com.walletmix.custometab.databinding.FragmentSaturdayBinding

class SaturdayFragment : Fragment() {

    private lateinit var binding: FragmentSaturdayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaturdayBinding.inflate(inflater, container, false)
        return binding.root
    }
}