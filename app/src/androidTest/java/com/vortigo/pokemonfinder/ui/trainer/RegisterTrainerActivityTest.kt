package com.vortigo.pokemonfinder.ui.trainer

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.vortigo.pokemonfinder.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.withId

@RunWith(AndroidJUnit4::class)
class RegisterTrainerActivityTest {

    @get:Rule
    var mActivityRule = ActivityTestRule(RegisterTrainerActivity::class.java, false, true)

    @Test
    fun whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(withId(R.id.txt_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_name)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.edt_name)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.img_goto_select)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun whenFieldIsFilled_andClickOnNextButton_shouldOpenSelectPokemonActivity() {
        Intents.init()

        onView(ViewMatchers.withId(R.id.edt_name)).perform(typeText("trainer"), closeSoftKeyboard())

        val matcher = IntentMatchers.hasComponent(SelectPokemonActivity::class.java.name)

        onView(ViewMatchers.withId(R.id.img_goto_select)).perform(click())

        Intents.intended(matcher)

        Intents.release()
    }

}