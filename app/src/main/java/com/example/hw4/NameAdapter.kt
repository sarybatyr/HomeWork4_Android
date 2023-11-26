package com.example.hw4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw4.databinding.ItemNameBinding

class NameAdapter(private val items: List<String>): RecyclerView.Adapter<NameAdapter.NameViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val layout_inflatter = LayoutInflater.from(parent.context)
        return NameViewHolder(ItemNameBinding.inflate(layout_inflatter, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.onBind(items[position])
    }


    class NameViewHolder(private val binding: ItemNameBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(item: String){
            binding.root.text = item
        }
    }
}