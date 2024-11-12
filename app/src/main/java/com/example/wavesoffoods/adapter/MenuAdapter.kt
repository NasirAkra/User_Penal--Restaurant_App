package com.example.wavesoffoods.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffoods.DetailsActivity
import com.example.wavesoffoods.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItems: List<String>,
    private val menuImages: List<Int>,
    private val menuItemsPrices: List<String>,
    private val requireContext:Context

) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val itemClickListener:OnClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position=adapterPosition
                if(position!=RecyclerView.NO_POSITION)
                {
                      itemClickListener?.onItemClick(position)
                }
                val intent=Intent(requireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItems[position])
                intent.putExtra("MenuItemImage", menuImages[position])
                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menufood.text = menuItems[position]
                menuprice.text = menuItemsPrices[position]
                imagemenu.setImageResource(menuImages[position])


            }
        }
    }

    interface OnClickListener{
        fun    onItemClick(position: Int)

    }
}

