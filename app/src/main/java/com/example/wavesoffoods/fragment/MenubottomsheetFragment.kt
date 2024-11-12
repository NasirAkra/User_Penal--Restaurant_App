package com.example.wavesoffoods.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffoods.R
import com.example.wavesoffoods.adapter.MenuAdapter
import com.example.wavesoffoods.databinding.FragmentMenubottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenubottomsheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenubottomsheetBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentMenubottomsheetBinding.inflate(inflater,container,false)
        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val menuFoodNames= listOf("Burger","Sandwich","Mamo","Burger","Sandwich","Item","Burger","Sandwich","Mamo","Burger","Sandwich","Item")
        val menuItemPrice= listOf("$5","$6","$7","$8","$9","$10","$5","$6","$7","$8","$9","$10")
        val menuImage= listOf(
            R.drawable.menu1 ,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu1 ,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6
        )
        val adapter = MenuAdapter(menuFoodNames, menuImage, menuItemPrice,requireContext())
        binding.menurecycleview.layoutManager= LinearLayoutManager(requireContext())
        binding.menurecycleview.adapter=adapter
        return binding.root

    }

    companion object
}