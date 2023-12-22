package com.walletmix.custometab.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.walletmix.custometab.QuotesViewModel
import com.walletmix.custometab.adapter.QuotesAdapter
import com.walletmix.custometab.databinding.FragmentFridayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FridayFragment : Fragment() {
    private lateinit var binding: FragmentFridayBinding
    private val viewModel: QuotesViewModel by viewModels()
    private lateinit var adapter: QuotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFridayBinding.inflate(inflater, container, false)
        adapter = QuotesAdapter()
        binding.tvTitle.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.getAllQuotesFromVM()
        }

        viewModel.quotes.observe(viewLifecycleOwner, Observer { quote ->
            adapter.submitList(quote.filter { responseQuotes -> responseQuotes.tags!!.contains("Famous Quotes") })
        })
    }
}