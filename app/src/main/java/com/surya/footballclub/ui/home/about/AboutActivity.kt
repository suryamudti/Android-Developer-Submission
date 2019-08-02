package com.surya.footballclub.ui.home.about

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.surya.footballclub.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About"

    }
}
