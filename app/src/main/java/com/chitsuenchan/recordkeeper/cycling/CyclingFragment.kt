package com.chitsuenchan.recordkeeper.cycling

import android.content.Context
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

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchRunningRecordScreen("Longest Ride") }
        binding.containerBiggestClimb.setOnClickListener { launchRunningRecordScreen("Biggest Climb") }
        binding.containerBestAverageSpeed.setOnClickListener { launchRunningRecordScreen("Best Average Speed") }
    }

    private fun displayRecords() {
        val cyclingPreferences = requireContext().getSharedPreferences("cycling", Context.MODE_PRIVATE)

        binding.textViewLongestRideValue.text = cyclingPreferences.getString("Longest Ride record", "No record set")
        binding.textViewLongestRideDate.text =  cyclingPreferences.getString("Longest Ride date", "No record set")
        binding.textViewBiggestClimbValue.text = cyclingPreferences.getString("Biggest Climb record", "No record set")
        binding.textViewBiggestClimbDate.text =  cyclingPreferences.getString("Biggest Climb date", "No record set")
        binding.textViewBestAverageSpeedValue.text = cyclingPreferences.getString("Best Average Speed record", "No record set")
        binding.textViewBestAverageSpeedDate.text =  cyclingPreferences.getString("Best Average Speed date", "No record set")
    }

    private fun launchRunningRecordScreen(cycling: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Cycling", cycling)

        startActivity(intent)
    }
}