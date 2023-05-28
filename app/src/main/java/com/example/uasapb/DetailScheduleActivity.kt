package com.example.uasapb

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasapb.fragment.ScheduleFragment

class DetailScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_schedule)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Schedule = intent.getParcelableExtra<Schedule>(ScheduleFragment.INTENT_PARCELABLE)

        val imageCircuit = findViewById<ImageView>(R.id.img_circuit_detail)
        val nameRace = findViewById<TextView>(R.id.name_race_detail)
        val nameCircuit = findViewById<TextView>(R.id.name_circuit_detail)
        val dateRace = findViewById<TextView>(R.id.date_detail)

        imageCircuit.setImageResource(Schedule?.imgCircuit!!)
        nameRace.text = Schedule.nameRace
        nameCircuit.text = Schedule.nameCircuit
        dateRace.text = Schedule.date

        val scheduleBackBtn = findViewById<ImageView>(R.id.schedule_back)
        scheduleBackBtn.setOnClickListener {
            finish()
        }

    }
}