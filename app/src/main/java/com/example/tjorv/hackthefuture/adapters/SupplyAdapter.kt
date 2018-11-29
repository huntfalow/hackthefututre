package com.example.tjorv.hackthefuture.adapters

import com.example.tjorv.hackthefuture.model.Supply
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tjorv.hackthefuture.databinding.ListItemSupplyBinding

class SupplyAdapter(private var supplyList : ArrayList<Supply>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemSupplyBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(supplyList[position])
    }

    //Gets the items inside the list
    override fun getItemCount(): Int {
        return supplyList.size
    }

    fun setSupplyList(supplies: ArrayList<Supply>) {
        supplyList = supplies
    }

    inner class ViewHolder(val binding: ListItemSupplyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Supply) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}