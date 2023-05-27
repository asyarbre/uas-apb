package com.example.uasapb

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasapb.fragment.TeamsFragment

class DetailTeamActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Team = intent.getParcelableExtra<Team>(TeamsFragment.INTENT_PARCELABLE)

        val imageCar = findViewById<ImageView>(R.id.car_photo_detail)
        val teamName = findViewById<TextView>(R.id.team_name)
        val teamChief = findViewById<TextView>(R.id.team_chief)
        val technicalChief = findViewById<TextView>(R.id.technical_chief)
        val baseTeam = findViewById<TextView>(R.id.base)
        val descTeam = findViewById<TextView>(R.id.team_desc)

        imageCar.setImageResource(Team?.photoCar!!)
        teamName.text = Team.nameTeam
        teamChief.text = Team.teamChief
        technicalChief.text = Team.technicalChief
        baseTeam.text = Team.base
        descTeam.text = Team.teamDesc

        val teamBackBtn = findViewById<ImageView>(R.id.team_back)
        teamBackBtn.setOnClickListener {
            finish()
        }
    }
}