package com.example.tjorv.hackthefuture.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tjorv.hackthefuture.R
import com.example.tjorv.hackthefuture.adapters.SupplyAdapter
import com.example.tjorv.hackthefuture.databinding.FragmentMainBinding
import com.example.tjorv.hackthefuture.model.Supply
import com.example.tjorv.hackthefuture.viewModels.MainViewModel

class MainFragment : Fragment() {

    private var supplies: ArrayList<Supply> = ArrayList()
    private val supplyAdapter = SupplyAdapter(supplies)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding : FragmentMainBinding = DataBindingUtil.inflate(inflater ,R.layout.fragment_main,container , false)
        val view : View  = binding.root

        val viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        binding.supplyViewModel = viewModel
        binding.setLifecycleOwner(activity)

        return view
    }

    private fun observeViewModel(viewModel: MainViewModel) {
        // Update the list when the data changes
        viewModel.getSupplyListObservable(activity?.getSharedPreferences("HTF", Context.MODE_PRIVATE)!!.getString("APIKey","")!!).observe(this,
            Observer<List<Supply>> { supplyAdapter.setSupplyList(supplies) })
    }
}
