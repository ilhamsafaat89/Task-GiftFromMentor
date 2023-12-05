package com.task.taskgift

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.task.taskgift.databinding.ActivityMainBinding
import com.task.taskgift.fragment.HomeFragment
import com.task.taskgift.fragment.NilaiWaliFragment

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        sharedPreferences = getSharedPreferences("Prefs", MODE_PRIVATE)

        setupActionBar()

        if (!sharedPreferences.getBoolean("isLoggedIn", false)) {
            navigateToLogin()
            return
        }

        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.menu_toko -> {
                    replaceFragment(NilaiWaliFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.actionBarHome)
        supportActionBar?.title = null
        binding.actionBarTitle.text = "Kita Ini Lapar!"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.iconkita_1)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }
}