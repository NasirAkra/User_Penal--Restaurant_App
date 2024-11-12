package com.example.wavesoffoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wavesoffoods.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName=intent.getStringExtra("MenuItemName")
        val foodImage=intent.getIntExtra("MenuItemImage",0)
        binding.foodnamedetails.text=foodName
        binding.imagefood.setImageResource(foodImage)
      binding.imageButton.setOnClickListener {
          finish()
      }

    }
}