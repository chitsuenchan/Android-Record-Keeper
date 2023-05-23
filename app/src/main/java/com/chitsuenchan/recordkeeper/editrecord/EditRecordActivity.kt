package com.chitsuenchan.recordkeeper.editrecord

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.chitsuenchan.recordkeeper.databinding.ActivityEditRecordBinding

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding


    private val recordPreferences: SharedPreferences by lazy {getSharedPreferences("running", Context.MODE_PRIVATE) }
    private val record: String? by lazy { intent.getStringExtra("Distance") }       // Here we are retrieving the putExtra data from distance using lazy



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Because we are inflating an activity window and not a fragment we just need to pass in layoutInflater
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
        displayRecord()

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

    private fun setupUi() {
        title = "$record Record"
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()        // We add finish here so that after saving the data we exit this fragment
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()        // We add finish here because after deleting contents we return to the previous screen
        }
    }

    private fun displayRecord() {
        val runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        // Here are we displaying the record saved in sharedpreferences in the edit boxes
        binding.editTextRecord.setText(runningPreferences.getString("$record record", null))
        binding.editTextDate.setText(runningPreferences.getString("$record date", null))
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        val runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        // This is how to save data to a new file
        runningPreferences.edit {
            putString("${this@EditRecordActivity.record} record", record)   // This is how to make a unique key. We will now have a key name for 5km, 10km, half-marathon and marathon
            putString("${this@EditRecordActivity.record} date", date)
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove("$record record")
            remove("$record date")
        }
    }

    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String
    )

}