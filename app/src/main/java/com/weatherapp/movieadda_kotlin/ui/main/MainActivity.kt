package com.weatherapp.movieadda_kotlin.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import com.weatherapp.movieadda_kotlin.R
import com.weatherapp.movieadda_kotlin.ui.main.home.HomeFragment
import com.weatherapp.movieadda_kotlin.ui.main.list.MovieListFragment
import com.weatherapp.movieadda_kotlin.ui.main.menu.MenuFragment
import com.weatherapp.movieadda_kotlin.ui.main.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace(HomeFragment())

        main_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replace(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Search -> {
                    replace(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.MyLists -> {
                    replace(MovieListFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Menu -> {
                    replace(MenuFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    fun replace(fragment: Fragment?) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame, fragment!!)
        ft.commit()
    }

}