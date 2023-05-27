package com.example.uasapb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(private val teamList: ArrayList<Team>, val listener: (Team) -> Unit) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCar: ImageView = itemView.findViewById(R.id.img_Car)
        val nameTeam: TextView = itemView.findViewById(R.id.tv_team)

        fun bindView(Team: Team, listener: (Team) -> Unit) {
            imageCar.setImageResource(Team.photoCar)
            nameTeam.text = Team.nameTeam
            itemView.setOnClickListener {
                listener(Team)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindView(teamList[position], listener)

        val currentItem = teamList[position]
        holder.imageCar.setImageResource(currentItem.photoCar)
        holder.nameTeam.text = currentItem.nameTeam
        itemCount
    }
}