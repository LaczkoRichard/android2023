package com.tasty.recipesapp.activity

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    companion object {
        val TAG = SplashActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val logo = binding.logo
        Handler().postDelayed({
            val animation = AnimationUtils.loadAnimation(this, R.anim.float_up_animation)
            logo.startAnimation(animation)
            logo.visibility = ImageView.VISIBLE
        }, 2000)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("message", "Hello from Splash!")
            startActivity(intent)
        },5000)

//-------------------------------------------------------------------//
//        val intent = Intent(this, MainActivity::class.java)        //
//        intent.putExtra("message", "Hello from Splash!")           //
//        startActivity(intent)                                      //
//-------------------------------------------------------------------//

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy: SplashActivity destroyed.")
    }

    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, "onStart: SplashActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume: SplashActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause: SplashActivity paused.")
    }
}