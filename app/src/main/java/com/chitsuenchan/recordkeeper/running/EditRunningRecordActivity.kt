package com.chitsuenchan.recordkeeper.running

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chitsuenchan.recordkeeper.databinding.ActivityEditRunningRecordBinding
import com.chitsuenchan.recordkeeper.databinding.FragmentRunningBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunningRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Because we are inflating an activity window and not a fragment we just need to pass in layoutInflater
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Here we are retrieving the putExtra data from distance
        val distance = intent.getStringExtra("Distance")

        title = "$distance Record"
    }
}