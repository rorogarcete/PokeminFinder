package com.bytemain.pokemonfinder.ui.main

import android.content.Intent
import android.os.Bundle
import com.bytemain.pokemonfinder.R
import com.bytemain.pokemonfinder.ui.base.BaseActivity

/**
 * @author rorogarcete
 * @version 0.0.1
 * Splash Screen of the App
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
class SplashActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        startPercentMockThread()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish(BaseActivity.ActivityAnimation.SLIDE_RIGHT)
    }

    private fun startPercentMockThread() {
        val runnable = Runnable {
            try {
                Thread.sleep(3000)
                openMainActivity()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        Thread(runnable).start()
    }

    private fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java), ActivityAnimation.SLIDE_LEFT)
        finish()
    }
}
