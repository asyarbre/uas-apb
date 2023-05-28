package com.example.uasapb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdapter(
    private val scheduleList: ArrayList<Schedule>,
    val listener: (Schedule) -> Unit
) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.date)
        val nameRace: TextView = itemView.findViewById(R.id.name_race)
        val nameCircuit: TextView = itemView.findViewById(R.id.name_circuit)
        val imgCircuit: ImageView = itemView.findViewById(R.id.img_circuit)

        fun bindView(Schedule: Schedule, listener: (Schedule) -> Unit) {
            date.text = Schedule.date
            nameRace.text = Schedule.nameRace
            nameCircuit.text = Schedule.nameCircuit
            imgCircuit.setImageResource(Schedule.imgCircuit)
            itemView.setOnClickListener {
                listener(Schedule)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bindView(scheduleList[position], listener)

        val currentItem = scheduleList[position]
        holder.date.text = currentItem.date
        holder.nameRace.text = currentItem.nameRace
        holder.nameCircuit.text = currentItem.nameCircuit
        holder.imgCircuit.setImageResource(currentItem.imgCircuit)
        itemCount
    }
}