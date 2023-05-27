package com.example.uasapb.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasapb.DetailTeamActivity
import com.example.uasapb.R
import com.example.uasapb.Team
import com.example.uasapb.TeamAdapter

class TeamsFragment : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: TeamAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var teamArrayList: ArrayList<Team>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_teams)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = TeamAdapter(teamArrayList){
            val intent = Intent(context,DetailTeamActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    private fun dataInitialize() {
        val dataTeamName = resources.getStringArray(R.array.data_team_name)
        val dataPhotoCar = resources.obtainTypedArray(R.array.data_team_car)
        val dataBase = resources.getStringArray(R.array.data_team_base)
        val dataTeamChief = resources.getStringArray(R.array.data_team_chief)
        val dataTechnicalChief = resources.getStringArray(R.array.data_team_technical)
        val dataDesc = resources.getStringArray(R.array.data_team_desc)

        teamArrayList = ArrayList<Team>()

        for (i in dataTeamName.indices) {
            val team = Team(
                dataTeamName[i],
                dataPhotoCar.getResourceId(i, -1),
                dataBase[i],
                dataTeamChief[i],
                dataTechnicalChief[i],
                dataDesc[i]
            )
            teamArrayList.add(team)
        }
    }
}