package com.example.wavesoffoods.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffoods.R
import com.example.wavesoffoods.adapter.NotificationAdapter
import com.example.wavesoffoods.databinding.FragmentMenubottomsheetBinding
import com.example.wavesoffoods.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notification_bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notifications= listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your order has placed ")
        val notificationsImages= listOf(R.drawable.sademoji, R.drawable.truck,R.drawable.congrats)
        val adapter=NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationsImages)
        )
        binding.notificationRecycleView.layoutManager=LinearLayoutManager(requireContext())
        binding.notificationRecycleView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}