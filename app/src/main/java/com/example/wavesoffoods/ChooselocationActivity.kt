package com.example.wavesoffoods

import android.os.Bundle
import android.widget.ArrayAdapter

import androidx.appcompat.app.AppCompatActivity

import com.example.wavesoffoods.databinding.ActivityChooselocationBinding


class ChooselocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooselocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooselocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val locationlist = arrayOf("Pakpattan","Lahore","Okara,","Shiwal")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationlist)
        val autoCompleteTextView = binding.listoflocation
        autoCompleteTextView.setAdapter(adapter)



    }
}