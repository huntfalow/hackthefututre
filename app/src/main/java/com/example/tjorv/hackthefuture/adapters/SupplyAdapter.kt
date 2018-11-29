package com.example.tjorv.hackthefuture.adapters

import com.example.tjorv.hackthefuture.model.Supply
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tjorv.hackthefuture.R

class SupplyAdapter(private val supplyList : ArrayList<Supply>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_supply, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(supplyList[position])
    }

    //Gets the items inside the list
    override fun getItemCount(): Int {
        return supplyList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(supply: Supply) {
            //TODO bind to views
        }

    }
}