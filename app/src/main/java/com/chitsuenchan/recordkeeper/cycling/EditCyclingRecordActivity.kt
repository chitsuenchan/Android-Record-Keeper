package com.chitsuenchan.recordkeeper.cycling

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.chitsuenchan.recordkeeper.databinding.ActivityEditCyclingRecordBinding
import com.chitsuenchan.recordkeeper.databinding.ActivityEditRunningRecordBinding
import com.chitsuenchan.recordkeeper.databinding.FragmentRunningBinding

class EditCyclingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunningRecordBinding
    private val cyclingPreferences: SharedPreferences by lazy {
        getSharedPreferences("cycling", Context.MODE_PRIVATE)
    }
    private val cyclingRecords: String? by lazy {intent.getStringExtra("Cycling")}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
        displayRecord()

    }

    private fun setupUi() {
        title = "$cyclingRecords Record"
        binding.buttonSave.setOnClickListener{
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }
    private fun displayRecord() {
        val cyclingPreferences = getSharedPreferences("cycling", Context.MODE_PRIVATE)

        binding.editTextRecord.setText(cyclingPreferences.getString("$cyclingRecords record", null))
        binding.editTextDate.setText(cyclingPreferences.getString("$cyclingRecords date", null))
        println("$cyclingRecords date")
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()
        val cyclingPreferences = getSharedPreferences("cycling", Context.MODE_PRIVATE)

        cyclingPreferences.edit {
            putString("$cyclingRecords record", record)
            putString("$cyclingRecords date", date)
        }
    }

    private fun clearRecord() {
        cyclingPreferences.edit {
            remove("$cyclingRecords record")
            remove("$cyclingRecords date")
        }
    }

}
