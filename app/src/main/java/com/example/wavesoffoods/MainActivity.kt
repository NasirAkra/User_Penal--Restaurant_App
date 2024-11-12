package com.example.wavesoffoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wavesoffoods.databinding.ActivityMainBinding
import com.example.wavesoffoods.fragment.Notification_bottom_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController=findNavController(R.id.fragmentContainerView9)
        val bottomna=findViewById<BottomNavigationView>(R.id.bottomNavigationView2)
        bottomna.setupWithNavController(navController)
        binding.notificationButton.setOnClickListener {
            val bottomSheetDialog = Notification_bottom_Fragment()
            bottomSheetDialog.show(supportFragmentManager, "Test")
        }

    }
}