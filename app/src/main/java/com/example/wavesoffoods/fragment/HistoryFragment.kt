package com.example.wavesoffoods.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffoods.R
import com.example.wavesoffoods.adapter.BuyAgainAdapter
import com.example.wavesoffoods.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter:BuyAgainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding=FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setUpRecycleView()
        return binding.root
    }
    private fun setUpRecycleView()
    {
        val buyAgainFoodName= arrayListOf("Food1","Food2","Food3")
        val buyAgainFoodPrice= arrayListOf("$35","$36","$37")
        val buyAgainFoodImage= arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)
        buyAgainAdapter=BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.BuyAgainRecycleView.adapter=buyAgainAdapter
        binding.BuyAgainRecycleView.layoutManager=LinearLayoutManager(requireContext())
    }

    companion object
}