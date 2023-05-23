package com.chitsuenchan.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chitsuenchan.recordkeeper.databinding.FragmentCyclingBinding
import com.chitsuenchan.recordkeeper.running.EditRunningRecordActivity

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchRunningRecordScreen("Longest Ride") }
        binding.containerBiggestClimb.setOnClickListener { launchRunningRecordScreen("Biggest Climb") }
        binding.containerBestAverageSpeed.setOnClickListener { launchRunningRecordScreen("Best Average Speed") }
    }

    private fun launchRunningRecordScreen(category: String) {
        val intent = Intent(context, EditRunningRecordActivity::class.java)

        intent.putExtra("Distance", category)

        startActivity(intent)

    }
}