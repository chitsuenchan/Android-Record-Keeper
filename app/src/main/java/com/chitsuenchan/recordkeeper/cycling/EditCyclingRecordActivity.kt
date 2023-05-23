package com.chitsuenchan.recordkeeper.cycling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chitsuenchan.recordkeeper.databinding.ActivityEditCyclingRecordBinding
import com.chitsuenchan.recordkeeper.databinding.ActivityEditRunningRecordBinding
import com.chitsuenchan.recordkeeper.databinding.FragmentRunningBinding

class EditCyclingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCyclingRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Because we are inflating an activity window and not a fragment we just need to pass in layoutInflater
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Here we are retrieving the putExtra data from distance
        val category = intent.getStringExtra("Category")

        title = "$category Record"
    }
}