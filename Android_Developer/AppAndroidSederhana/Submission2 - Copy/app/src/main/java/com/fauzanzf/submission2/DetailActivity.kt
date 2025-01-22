package com.fauzanzf.submission2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        @Suppress("DEPRECATION")
        val city = intent.getParcelableExtra<City>("CITY")
        if (city != null) {
            findViewById<TextView>(R.id.tv_item_name).text = city.name
            findViewById<ImageView>(R.id.img_item_photo).setImageResource(city.photo)
        } else {
            Toast.makeText(this, "Data city tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}