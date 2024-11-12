package com.example.wavesoffoods.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffoods.databinding.BuyAgainItemBinding
import java.util.ArrayList

class BuyAgainAdapter(
    private val buyAgainFoodName: ArrayList<String>,
    private val buyAgainFoodPrice: ArrayList<String>,
    private val buyAgainFoodImage: ArrayList<Int>,
)
    : RecyclerView.Adapter<BuyAgainAdapter.BuyagainViewHolder>() {

    override fun onBindViewHolder(holder: BuyagainViewHolder, position: Int) {
        holder.bind(buyAgainFoodImage[position],buyAgainFoodPrice[position],buyAgainFoodName[position])
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyagainViewHolder {
      val binding=BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyagainViewHolder(binding)
    }

    override fun getItemCount(): Int =buyAgainFoodName.size
    class BuyagainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(foodImage: Int, foodname: String, foodPrice: String) {
            binding.buyAgainFoodName.text=foodname
            binding.buyAgainFoodPrice.text=foodPrice
            binding.buyAgainFoodImage.setImageResource(foodImage)

        }

    }



}