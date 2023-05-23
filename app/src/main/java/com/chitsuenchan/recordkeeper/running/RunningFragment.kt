package com.chitsuenchan.recordkeeper.running

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chitsuenchan.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Because we inflating a fragment instead of an activity view, we need 3 parameters
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Instead of writing our logic in onCreateView we should do it in onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningRecordScreen("Marathon") }
    }

    private fun launchRunningRecordScreen(distance: String) {

        // In activity class we should use 'this' whereas in fragments we use 'context'
        val intent = Intent(context, EditRunningRecordActivity::class.java)

        // Here we are adding extra data into our intent view which is the distance/title text
        // Below we are labelling are extra data as "Distance" and passing the data in the distance variable
        intent.putExtra("Distance", distance)

        startActivity(intent)
    }

}