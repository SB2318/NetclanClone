package com.sb2318.netclanclone


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.slider.Slider
import com.sb2318.netclanclone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // create nav controller
        navController= navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)
    }
}