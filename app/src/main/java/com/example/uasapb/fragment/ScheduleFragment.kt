package com.example.uasapb.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasapb.DetailScheduleActivity
import com.example.uasapb.R
import com.example.uasapb.Schedule
import com.example.uasapb.ScheduleAdapter

class ScheduleFragment : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: ScheduleAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var scheduleArrayList: ArrayList<Schedule>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_schedule)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ScheduleAdapter(scheduleArrayList){
            val intent = Intent(context, DetailScheduleActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    private fun dataInitialize() {
        val dataDate = resources.getStringArray(R.array.data_date_race)
        val dataNameRace = resources.getStringArray(R.array.data_race)
        val dataNameCircuit = resources.getStringArray(R.array.data_name_circuit)
        val circuitImg = resources.obtainTypedArray(R.array.data_img_circuit)

        scheduleArrayList = ArrayList<Schedule>()

        for (i in dataDate.indices) {
            val schedule = Schedule(
                dataDate[i],
                dataNameRace[i],
                dataNameCircuit[i],
                circuitImg.getResourceId(i, -1),
            )
            scheduleArrayList.add(schedule)
        }

    }
}