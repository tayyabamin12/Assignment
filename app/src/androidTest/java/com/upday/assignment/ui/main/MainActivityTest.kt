package com.upday.assignment.ui.main


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.upday.assignment.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val imageView = onView(
            allOf(
                withContentDescription("Android System notification: USB debugging connected"),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val imageView2 = onView(
            allOf(
                withContentDescription("Android System notification: USB debugging connected"),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val recyclerView = onView(
            allOf(
                withId(R.id.rv_main),
                withParent(
                    allOf(
                        withId(R.id.main),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))

        val imageView3 = onView(
            allOf(
                withId(R.id.iv_image),
                withParent(withParent(withId(R.id.rv_main))),
                isDisplayed()
            )
        )
        imageView3.check(matches(isDisplayed()))
    }
}
