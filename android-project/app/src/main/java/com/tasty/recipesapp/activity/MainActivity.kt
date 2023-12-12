package com.tasty.recipesapp.activity

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: MainActivity created.")
        //change text of mainActivityText to the one from the intent

//        binding.mainActivityText.text = intent.getStringExtra("message")

        navigationInit(binding)
    }



//    binding.buttonMainActivity.setOnClickListener {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("message", binding.buttonMainActivity.text.toString())
//        startActivity(intent)
//        finish()
//    }
    private fun navigationInit(binder: ActivityMainBinding) {
    binder.bottomNav.setOnItemSelectedListener {
        when (it.itemId) {
            R.id.homeFragment -> {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                navHostFragment.navController.navigate(R.id.homeFragment)
                return@setOnItemSelectedListener true
            }
            R.id.recipesFragment -> {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                navHostFragment.navController.navigate(R.id.recipesFragment)
                return@setOnItemSelectedListener true
            }
            R.id.profileFragment -> {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                navHostFragment.navController.navigate(R.id.profileFragment)
                return@setOnItemSelectedListener true
            }
            else -> {
                return@setOnItemSelectedListener false
            }
        }
    }
}
    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause: MainActivity paused.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy: MainActivity destroyed.")
    }
}


