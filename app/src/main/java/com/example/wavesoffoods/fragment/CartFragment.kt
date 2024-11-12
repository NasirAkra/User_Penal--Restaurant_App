package com.example.wavesoffoods.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffoods.PayOutActivity
import com.example.wavesoffoods.R
import com.example.wavesoffoods.adapter.CartAdapter
import com.example.wavesoffoods.databinding.FragmentCartBinding


class CartFragment : Fragment() {
private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val cartFoodNames= listOf("Burger","Sandwich","Mamo","Burger","Sandwich","Item")
        val cartItemPrice= listOf("$5","$6","$7","$8","$9","$10")
        val cartImage= listOf(
            R.drawable.menu6 ,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6
        )
        val adapter=CartAdapter(ArrayList(cartFoodNames),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartrecycleview.layoutManager=LinearLayoutManager(requireContext())
        binding.cartrecycleview.adapter=adapter
        binding.proceedbutton.setOnClickListener{
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root

    }

    companion object
}