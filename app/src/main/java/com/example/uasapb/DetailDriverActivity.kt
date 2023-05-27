package com.example.uasapb

import Driver
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasapb.fragment.DriversFragment

class DetailDriverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_driver)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Driver = intent.getParcelableExtra<Driver>(DriversFragment.INTENT_PARCELABLE)

        val imageDriver = findViewById<ImageView>(R.id.driver_photo_detail)
        val firstNameDriver = findViewById<TextView>(R.id.driver_first_name)
        val lastNameDriver = findViewById<TextView>(R.id.driver_last_name)
        val teamDriver = findViewById<TextView>(R.id.driver_team)
        val champDriver = findViewById<TextView>(R.id.driver_champ)
        val podiumDriver = findViewById<TextView>(R.id.driver_podium)
        val descDriver = findViewById<TextView>(R.id.driver_desc)
        val countryDriver = findViewById<TextView>(R.id.driver_country)
        val flagDriver = findViewById<ImageView>(R.id.driver_country_flag)

        imageDriver.setImageResource(Driver?.driverPhotoDetail!!)
        firstNameDriver.text = Driver.firstName
        lastNameDriver.text = Driver.lastName
        teamDriver.text = Driver.driverTeam
        champDriver.text = Driver.driverChamp.toString()
        podiumDriver.text = Driver.driverPodium.toString()
        descDriver.text = Driver.driverDesc
        countryDriver.text = Driver.driverCountry
        flagDriver.setImageResource(Driver?.driverFlag!!)

        //intent back button finish()
        val backBtn = findViewById<ImageView>(R.id.back_btn)
        backBtn.setOnClickListener {
            finish()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}