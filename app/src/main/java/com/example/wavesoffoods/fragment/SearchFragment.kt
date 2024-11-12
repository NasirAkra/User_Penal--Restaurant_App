package com.example.wavesoffoods.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffoods.R
import com.example.wavesoffoods.adapter.MenuAdapter
import com.example.wavesoffoods.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter


    private val originalMenuFoodNames = mutableListOf("Burger", "Sandwich", "Mamo", "Item","Burger", "Sandwich", "Mamo", "Item")
    private val originalMenuItemPrices = mutableListOf("$5", "$6", "$7", "$10","$5", "$6", "$7", "$10")
    private val originalMenuImages = mutableListOf(
        R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4,
        R.drawable.menu4, R.drawable.menu5, R.drawable.menu6, R.drawable.menu7
    )


    private val filteredMenuFoodNames = mutableListOf<String>()
    private val filteredMenuItemPrices = mutableListOf<String>()
    private val filteredMenuImages = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)


        showAllMenu()

        setupSearchView()
        return binding.root
    }


    private fun showAllMenu() {
        filteredMenuFoodNames.clear()
        filteredMenuItemPrices.clear()
        filteredMenuImages.clear()

        filteredMenuFoodNames.addAll(originalMenuFoodNames)
        filteredMenuItemPrices.addAll(originalMenuItemPrices)
        filteredMenuImages.addAll(originalMenuImages)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = MenuAdapter(filteredMenuFoodNames, filteredMenuImages, filteredMenuItemPrices,requireContext())
        binding.menurecycleview.layoutManager = LinearLayoutManager(requireContext())
        binding.menurecycleview.adapter = adapter
    }


    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }
        })
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItem(query: String) {
        filteredMenuFoodNames.clear()
        filteredMenuItemPrices.clear()
        filteredMenuImages.clear()

        originalMenuFoodNames.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodNames.add(foodName)
                filteredMenuItemPrices.add(originalMenuItemPrices[index])
                filteredMenuImages.add(originalMenuImages[index])
            }
        }

        adapter.notifyDataSetChanged()
    }
}
