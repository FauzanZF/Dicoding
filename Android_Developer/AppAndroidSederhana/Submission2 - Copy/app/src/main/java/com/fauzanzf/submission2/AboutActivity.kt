package com.fauzanzf.submission2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() { // Tambahan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about) // Tambahan
        supportActionBar?.title = "About Me" // Tambahan
    }
}
