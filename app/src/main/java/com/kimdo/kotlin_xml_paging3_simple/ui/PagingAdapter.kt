package com.kimdo.kotlin_xml_paging3_simple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kimdo.kotlin_xml_paging3_simple.databinding.ItemSampleBinding

class PagingAdapter : PagingDataAdapter<String, PagingViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding =  ItemSampleBinding.inflate(layoutInflater, parent, false)
        return PagingViewHolder( binding )
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind( item )
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class PagingViewHolder(
    private val binding: ItemSampleBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String?) {
        binding.textView.text = data ?: ""
    }
}