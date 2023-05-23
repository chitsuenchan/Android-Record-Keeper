package com.chitsuenchan.recordkeeper.running

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.chitsuenchan.recordkeeper.databinding.ActivityEditRunningRecordBinding

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

        displayRecord(distance)
        binding.buttonSave.setOnClickListener {
            saveRecord(distance)
            finish()        // We add finish here so that after saving the data we exit this fragment
        }


        // Used for application wide saved data
        // e.g. user settings or user preferences
//        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        applicationPreferences.edit {
//            putString("Some application data", "Application preference value ")
//        }

        // Used to save data for a specific activity screen
        // Rarely used in the the industry
//        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
//        activityPreferences.edit {
//            putInt("Some activity data", 15)
//        }

        // Allow you to create as many data files as needed with custom names
        // The most useful in the industry
        // All data files are stored in Device File Explorer under data>data>com.chitsuenchan.recordkeeper>shared_prefs
//        val fileNamePreferences = getSharedPreferences("Some shared preference file name", Context.MODE_PRIVATE)
//        fileNamePreferences.edit {
//            putBoolean("Some preference file name data", false)
//        }

    }

    private fun displayRecord(distance: String?) {
        val runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        // Here are we displaying the record saved in sharedpreferences in the edit boxes
        binding.editTextRecord.setText(runningPreferences.getString("$distance record", null))
        binding.editTextDate.setText(runningPreferences.getString("$distance date", null))
    }

    private fun saveRecord(distance: String?) {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        val runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        // This is how to save data to a new file
        runningPreferences.edit {
            putString("$distance record", record)   // This is how to make a unique key. We will now have a key name for 5km, 10km, half-marathon and marathon
            putString("$distance date", date)
        }
    }
}