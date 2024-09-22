package com.scifi.valesport

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvEsports: RecyclerView
    private val list = ArrayList<Esport>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvEsports = findViewById(R.id.rv_esports)
        rvEsports.setHasFixedSize(true)

        list.addAll(getListEsports())
        showRecyclerList()
    }


    private fun getListEsports(): ArrayList<Esport> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataLogo = resources.getStringArray(R.array.data_logo)
        val dataRoster = resources.getStringArray(R.array.data_roster)
        val dataEarning = resources.getStringArray(R.array.data_earning)
        val dataAchievement = resources.getStringArray(R.array.data_achievement)
        val dataSite = resources.getStringArray(R.array.data_site)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listEsport = ArrayList<Esport>()
        for (i in dataName.indices) {
            val esport = Esport(dataName[i], dataDescription[i], dataLogo[i], dataRoster[i], dataEarning[i], dataAchievement[i], dataSite[i], dataPhoto[i])
            listEsport.add(esport)
        }
        return listEsport
    }

    private fun showRecyclerList() {
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvEsports.layoutManager = LinearLayoutManager(this)
        } else {
            rvEsports.layoutManager = GridLayoutManager(this,2)
        }

        val listEsportAdapter = ListEsportAdapter(list)
        rvEsports.adapter = listEsportAdapter
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}