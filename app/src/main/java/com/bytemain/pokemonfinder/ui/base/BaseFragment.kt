package com.bytemain.pokemonfinder.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.WindowManager
import com.bytemain.pokemonfinder.R

/**
 * @author rorogarcete
 * @version 0.0.1
 * Class Base to Fragment
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun startActivity(intent: Intent, animation: BaseActivity.ActivityAnimation) {
        startActivity(intent)
        putAnimation(activity, animation)
    }

    fun startActivityForResult(intent: Intent, requestCode: Int, animation: BaseActivity.ActivityAnimation) {
        startActivityForResult(intent, requestCode)
        putAnimation(activity, animation)
    }

    private fun putAnimation(source: Activity?, animation: BaseActivity.ActivityAnimation) {
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

    private fun getAnimation(animation: BaseActivity.ActivityAnimation): IntArray {
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