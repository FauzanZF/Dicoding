package com.fauzanzf.submission2

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.car.ui.toolbar.MenuItem


class MainActivity : AppCompatActivity() {
    private lateinit var rvCities: RecyclerView
    private val list = ArrayList<City>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCities = findViewById(R.id.rv_cities)
        rvCities.setHasFixedSize(true)

        list.addAll(getListCities())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCities.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCities.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCities(): ArrayList<City> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCity = ArrayList<City>()
        for (i in dataName.indices) {
            val city = City(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCity.add(city)
        }
        return listCity
    }

    private fun showRecyclerList() {
        rvCities.layoutManager = LinearLayoutManager(this)
        val listCityAdapter = ListCityAdapter(list)
        rvCities.adapter = listCityAdapter

        listCityAdapter.setOnItemClickCallback(object : ListCityAdapter.OnItemClickCallback {
            override fun onItemClicked(data: City) {
                showSelectedCity(data)
            }
        })
    }

    private fun showSelectedCity(city: City) {
        Toast.makeText(this, "Kamu memilih " + city.name, Toast.LENGTH_SHORT).show()
    }
}