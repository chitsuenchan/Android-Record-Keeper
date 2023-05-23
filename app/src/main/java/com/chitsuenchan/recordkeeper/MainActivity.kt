package com.chitsuenchan.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.commit
import com.chitsuenchan.recordkeeper.cycling.CyclingFragment
import com.chitsuenchan.recordkeeper.databinding.ActivityMainBinding
import com.chitsuenchan.recordkeeper.running.RunningFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    // This is from AppCompatActivity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)

        // To make sure it option menu is displayed we need to do return true in this method
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.reset_running -> {
            Toast.makeText(this, "Clicked the reset running menu item", Toast.LENGTH_LONG).show()
            true
        }

        R.id.reset_cycling -> {
            Toast.makeText(this,"Clicked the reset cycling menu item", Toast.LENGTH_LONG).show()
            true
        }

        R.id.reset_all -> {
            Toast.makeText(this, "Clicked the reset all menu item", Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }

    }

    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        // We return true here because in the onNavigationItemSelected kotlin is inferring we are
        // going to return a boolean value so we return true here so it's return in that when method
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_cycling -> onCyclingClicked()
        R.id.nav_running -> onRunningClicked()
        else -> false
    }
}