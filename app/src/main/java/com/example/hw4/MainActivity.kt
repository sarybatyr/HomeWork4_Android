package com.example.hw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.hw4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragmentFirst) as NavHost
//        navController = navHostFragment.navController
    }
}