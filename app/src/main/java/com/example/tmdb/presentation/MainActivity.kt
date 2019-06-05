package com.example.tmdb.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tmdb.R
import com.example.tmdb.presentation.view.list.MoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesFragment())
                .commit()
        }
    }
}
