package com.example.uasapb.fragment

import Driver
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasapb.DetailDriverActivity
import com.example.uasapb.DriverAdapter
import com.example.uasapb.R

class DriversFragment : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: DriverAdapter
    private lateinit var recylerView: RecyclerView
    private lateinit var driverArrayList: ArrayList<Driver>

    lateinit var image: Array<Int>
    lateinit var firstName: Array<String>
    lateinit var lastName: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drivers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recylerView = view.findViewById(R.id.rv_driver)
        recylerView.layoutManager = layoutManager
        recylerView.setHasFixedSize(true)
        recylerView.adapter = DriverAdapter(driverArrayList) {
            val intent = Intent(context, DetailDriverActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    // data from string.xml
    private fun dataInitialize() {
        val dataFirstName = resources.getStringArray(R.array.data_first_name)
        val dataLastName = resources.getStringArray(R.array.data_last_name)
        val dataPhotoDriver = resources.obtainTypedArray(R.array.data_photo_driver)
        val dataPhotoDriverDetail = resources.obtainTypedArray(R.array.data_photo_driver_detail)
        val dataDriverTeam = resources.getStringArray(R.array.data_driver_team)
        val dataDriverChap = resources.getIntArray(R.array.data_driver_champ)
        val dataDriverPodium = resources.getIntArray(R.array.data_driver_podium)
        val dataDriverCountry = resources.getStringArray(R.array.data_driver_country)
        val dataDriverFlag = resources.obtainTypedArray(R.array.data_driver_flag)
        val dataDriverDesc = resources.getStringArray(R.array.data_driver_desc)

        driverArrayList = ArrayList<Driver>()

        for (i in dataFirstName.indices) {
            val driver = Driver(
                dataFirstName[i],
                dataLastName[i],
                dataPhotoDriver.getResourceId(i, -1),
                dataPhotoDriverDetail.getResourceId(i, -1),
                dataDriverTeam[i],
                dataDriverChap[i],
                dataDriverPodium[i],
                dataDriverCountry[i],
                dataDriverFlag.getResourceId(i, -1),
                dataDriverDesc[i]
            )
            driverArrayList.add(driver)
        }
    }
}