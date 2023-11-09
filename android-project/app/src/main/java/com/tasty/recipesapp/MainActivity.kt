package com.tasty.recipesapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: MainActivity created.")
        //change text of mainActivityText to the one from the intent

        binding.mainActivityText.text = intent.getStringExtra("message")

    }



//    binding.buttonMainActivity.setOnClickListener {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("message", binding.buttonMainActivity.text.toString())
//        startActivity(intent)
//        finish()
//    }

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


