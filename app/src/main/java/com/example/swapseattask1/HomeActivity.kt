package com.example.swapseattask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(Fragment1())
        bottomNav=findViewById(R.id.bottom_navbar)
        bottomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.icon_home -> {loadFragment(Fragment1()) }
                R.id.icon_offers -> {loadFragment(Fragment2()) }
                R.id.icon_profile -> {loadFragment(Fragment3()) }
            }
            true
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}