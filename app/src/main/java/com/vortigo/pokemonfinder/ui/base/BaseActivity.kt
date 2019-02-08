package com.vortigo.pokemonfinder.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vortigo.pokemonfinder.R

/**
 * @author rorogarcete
 * @version 0.0.1
 * Base Activity to Application
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    enum class ActivityAnimation {
        SLIDE_LEFT, SLIDE_RIGHT
    }

    fun startActivity(intent: Intent, animation: ActivityAnimation) {
        startActivity(intent)
        putAnimation(this, animation)
    }

    fun startActivityForResult(intent: Intent, requestCode: Int, animation: ActivityAnimation) {
        startActivityForResult(intent, requestCode)
        putAnimation(this, animation)
    }

    fun finish(animation: ActivityAnimation) {
        finish()
        putAnimation(this, animation)
    }

    private fun putAnimation(
        source: Activity,
        animation: ActivityAnimation
    ) {
        try {
            val method = Activity::class.java.getMethod(
                "overridePendingTransition",
                Int::class.javaPrimitiveType,
                Int::class.javaPrimitiveType
            )

            val animations = getAnimation(animation)
            method.invoke(source, animations[0], animations[1])
        } catch (e: Exception) {
            e.stackTrace
        }

    }

    private fun getAnimation(animation: ActivityAnimation): IntArray {
        val exitAnim: Int
        val enterAnim: Int

        when (animation) {
            BaseActivity.ActivityAnimation.SLIDE_RIGHT -> {
                enterAnim = R.anim.slide_right_enter
                exitAnim = R.anim.slide_right_exit
            }

            BaseActivity.ActivityAnimation.SLIDE_LEFT -> {
                enterAnim = R.anim.slide_left_enter
                exitAnim = R.anim.slide_left_exit
            }
        }

        return intArrayOf(enterAnim, exitAnim)
    }
}
