package com.example.project_mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.project_mobile.fragments.BlogFragment
import com.example.project_mobile.fragments.HomepageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener {
            menuItem ->
            when(menuItem.itemId) {
                R.id.bottom_home -> {
                    replaceFragment(HomepageFragment())
                    true
                }
                R.id.bottom_appointment -> {
//                    replaceFragment(SearchFragment())
                    true
                }
                R.id.bottom_favourite -> {
//                    replaceFragment(ProfileFragment())
                    true
                }
                R.id.bottom_blog -> {
                    replaceFragment(BlogFragment())
                    true
                }
                R.id.bottom_profile -> {
//                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        replaceFragment(HomepageFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}