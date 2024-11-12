package com.example.wavesoffoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wavesoffoods.databinding.ActivityPayOutBinding
import com.example.wavesoffoods.fragment.CongratsBottomSheetFragment

class PayOutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root )
        binding.PlaceMyOrder.setOnClickListener{
            val bottomSheetDialog= CongratsBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
     binding.backbutton.setOnClickListener {
         finish()
     }

    }
}