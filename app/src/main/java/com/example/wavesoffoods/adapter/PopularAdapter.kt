package com.example.wavesoffoods.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffoods.DetailsActivity
import com.example.wavesoffoods.databinding.PapoularItemBinding


class PopularAdapter(
    private val items: List<String>,
    private val price: List<String>,
    private val images: List<Int>, // Should be a List of image resource IDs
    private val context: Context // The correct Context for starting an activity
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PapoularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val itemName = items[position]
        val itemImage = images[position]
        val itemPrice = price[position]
        holder.bind(itemName, itemPrice, itemImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("MenuItemName", itemName)
            intent.putExtra("MenuItemImage", itemImage)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder(private val binding: PapoularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageView6

        fun bind(itemName: String, itemPrice: String, itemImage: Int) {
            binding.textView31.text = itemName
            binding.price.text = itemPrice
            imageView.setImageResource(itemImage)
        }
    }
}