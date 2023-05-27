package com.example.uasapb

import Driver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DriverAdapter(private val driverList: ArrayList<Driver>, val listener: (Driver) -> Unit) :
    RecyclerView.Adapter<DriverAdapter.DriverViewHolder>() {

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        holder.bindView(driverList[position], listener)

        val currentItem = driverList[position]
        holder.imageView.setImageResource(currentItem.driverPhoto)
        holder.firstName.text = currentItem.firstName
        holder.lastName.text = currentItem.lastName
        itemCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_driver, parent, false)
        return DriverViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return driverList.size
    }


    class DriverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_driver_photo)
        val firstName: TextView = itemView.findViewById(R.id.tv_first_name)
        val lastName: TextView = itemView.findViewById(R.id.tv_last_name)

        fun bindView(Driver: Driver, listener: (Driver) -> Unit) {
            imageView.setImageResource(Driver.driverPhoto)
            firstName.text = Driver.firstName
            lastName.text = Driver.lastName
            itemView.setOnClickListener {
                listener(Driver)
            }
        }
    }
}