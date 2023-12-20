package com.walletmix.custometab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.walletmix.custometab.databinding.ViewHolderQuotesBinding
import com.walletmix.custometab.models.ResponseQuotes

class QuotesAdapter :
    ListAdapter<ResponseQuotes, QuotesAdapter.QuotesViewHolder>(COMPARATOR) {

    class QuotesViewHolder(val binding: ViewHolderQuotesBinding) :
        RecyclerView.ViewHolder(binding.root)


    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<ResponseQuotes>() {
            override fun areItemsTheSame(
                oldItem: ResponseQuotes,
                newItem: ResponseQuotes
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseQuotes,
                newItem: ResponseQuotes
            ): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        return QuotesViewHolder(
            ViewHolderQuotesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        getItem(position).let {
            holder.binding.tvTitle.text = it.content
        }
    }
}