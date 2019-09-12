package com.efhem.socialmedia.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.efhem.socialmedia.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, com.efhem.socialmedia.R.layout.activity_main)
        val bottomNavigationView = binding.bottomNavigation
        val appToolbar = binding.toolbar
        setSupportActionBar(appToolbar)
        //appToolbar.setTitleTextColor(resources.getColor(R.color.white))

        val topLevel = HashSet<Int>()
        topLevel.add(com.efhem.socialmedia.R.id.homeFragment)
        topLevel.add(com.efhem.socialmedia.R.id.searchFragment)
        topLevel.add(com.efhem.socialmedia.R.id.mainFragment)
        topLevel.add(com.efhem.socialmedia.R.id.notificationFragment)
        topLevel.add(com.efhem.socialmedia.R.id.profileFragment)

        //Setting up toolbar, appbarconf, toplevel with nav takes care of the upbutton
        appBarConfiguration = AppBarConfiguration.Builder(topLevel).build()
        navController = Navigation.findNavController(this, com.efhem.socialmedia.R.id.fragment_host)
        NavigationUI.setupWithNavController(appToolbar, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            navController
        ) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(com.efhem.socialmedia.R.menu.up_menu, menu)
        return true
    }
}
