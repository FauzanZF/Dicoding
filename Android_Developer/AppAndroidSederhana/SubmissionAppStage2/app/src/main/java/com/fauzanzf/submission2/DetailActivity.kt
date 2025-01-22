package com.fauzanzf.submission2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Inisialisasi View
        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvPulau: TextView = findViewById(R.id.tv_detail_pulau)
        val tvTahun: TextView = findViewById(R.id.tv_detail_tahun)
        val tvUmur: TextView = findViewById(R.id.tv_detail_umur)
        val tvIbukota: TextView = findViewById(R.id.tv_detail_ibukota)

        // Ambil data dari Intent
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val pulau = intent.getStringExtra(EXTRA_PULAU)
        val tahun = intent.getStringExtra(EXTRA_TAHUN)
        val umur = intent.getStringExtra(EXTRA_UMUR)
        val ibuKota = intent.getStringExtra(EXTRA_IBUKOTA)


        // Set data ke View
        imgPhoto.setImageResource(photo)
        tvName.text = name
        tvDescription.text = description
        tvPulau.text = pulau
        tvTahun.text = tahun
        tvUmur.text = umur
        tvIbukota.text = ibuKota
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_PULAU = "extra_pulau"
        const val EXTRA_TAHUN = "extra_tahun"
        const val EXTRA_UMUR = "extra_umur"
        const val EXTRA_IBUKOTA = "extra_ibukota"

    }
}
