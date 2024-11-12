package com.example.wavesoffoods.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffoods.databinding.CartItemBinding

class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemsPrice: MutableList<String>,
    private var kattImage: MutableList<Int>,
): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantities = IntArray(cartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size
    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(position: Int) {
            binding.apply {

                val quality = itemQuantities[position]
                cartfoodname.text = cartItems[position]
                cartitemprice.text = cartItemsPrice[position]
                cartimage.setImageResource(kattImage[position])
                cartitemquanity.text = quality.toString()

                binding.minusbutton.setOnClickListener {
                    descreseQuantity(position)


                }
                binding.plusbutton.setOnClickListener {
                    increseQuantity(position)


                }
                binding.deletButton.setOnClickListener {
                    val itempositon=adapterPosition
                    if(itempositon!=RecyclerView.NO_POSITION)
                    {
                        deletQuantity(itempositon)
                    }



                }


            }
        }


        private fun deletQuantity(position: Int) {
            cartItems.removeAt(position)
            kattImage.removeAt(position)
            cartItemsPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)


        }

        private fun increseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.cartitemquanity.text = itemQuantities[position].toString()
            }
        }

        private fun descreseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.cartitemquanity.text = itemQuantities[position].toString()
            }
        }

    }
}

