package com.example.uasapb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uasapb.fragment.DriversFragment
import com.example.uasapb.fragment.ResultFragment
import com.example.uasapb.fragment.ScheduleFragment
import com.example.uasapb.fragment.TeamsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scheduleFragment = ScheduleFragment()
        val resultFragment = ResultFragment()
        val driversFragment = DriversFragment()
        val teamsFragment = TeamsFragment()

        makeCurrentFragment (scheduleFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_schedule -> makeCurrentFragment(scheduleFragment)
                R.id.menu_result -> makeCurrentFragment(resultFragment)
                R.id.menu_drivers -> makeCurrentFragment(driversFragment)
                R.id.menu_teams -> makeCurrentFragment(teamsFragment)
            }

            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }
}