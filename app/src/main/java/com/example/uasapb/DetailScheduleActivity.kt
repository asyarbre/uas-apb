package com.example.uasapb

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasapb.fragment.ScheduleFragment
import java.util.*

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

        //split date race to array like Jun 5-7 to [Jun, 5, 7]
        val date = Schedule.date
        val dateSplit = date.split(Regex(" |-"))
        val month = dateSplit[0]
        val startDate = dateSplit[1].toInt()
        val endDate = dateSplit[2].toInt()

        // convert month to number, like Jan to 0, Feb to 1, etc
        fun convertMonth(monthName: String): Int {
            val listMonth = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
            return listMonth.indexOf(monthName)
        }

        val monthNumber = convertMonth(month)

        val startMillis: Long = Calendar.getInstance().run {
            set(2023, monthNumber, startDate, 7, 30)
            timeInMillis
        }

        val endMillis: Long = Calendar.getInstance().run {
            set(2023, monthNumber, endDate, 7, 30)
            timeInMillis
        }

        //insert date race to calendar app on device
        val btnAdd = findViewById<Button>(R.id.btn_add_calendar)
        btnAdd.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, Schedule.nameRace)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, Schedule.nameCircuit)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startMillis)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMillis)
            startActivity(intent)
        }

    }
}