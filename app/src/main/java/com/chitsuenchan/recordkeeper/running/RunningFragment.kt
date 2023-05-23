package com.chitsuenchan.recordkeeper.running

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chitsuenchan.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

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

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        // We place displayRecords here so everytime we open this fragment it displays the record
        // Otherwise, if users press the android back button to go back to this fragment. The screen won't refresh/
        displayRecords()
    }


    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningRecordScreen("Marathon") }
    }
    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences("running", Context.MODE_PRIVATE)     // Here we are accessing the shared preferences file

        binding.textView5kmValue.text = runningPreferences.getString("5km record", "No record set")     // the second argument is a fall-back value if there is none
        binding.textView5kmDate.text =  runningPreferences.getString("5km date", null)       // fall-back value can also be null
        binding.textView10kmValue.text = runningPreferences.getString("10km record", null)
        binding.textView10kmDate.text =  runningPreferences.getString("10km date", null)
        binding.textViewHalfMarathonValue.text = runningPreferences.getString("Half Marathon record", null)
        binding.textViewHalfMarathonDate.text =  runningPreferences.getString("Half Marathon date", null)
        binding.textViewMarathonValue.text = runningPreferences.getString("Marathon record", null)
        binding.textViewMarathonDate.text =  runningPreferences.getString("Marathon date", null)

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