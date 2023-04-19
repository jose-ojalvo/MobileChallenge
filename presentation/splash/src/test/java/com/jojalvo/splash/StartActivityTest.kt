package com.jojalvo.splash

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle.State.CREATED
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jojalvo.framework.base.application.CustomApplicationTest_Application
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 *   @author jojalvo
 *   @since 19/4/23
 *   @email josealejandro025@gmail.com
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@Config(application = CustomApplicationTest_Application::class)
class StartActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = activityScenarioRule<StartActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun startActivity_launchActivity_noReturn() {
        launchActivity<StartActivity>()
    }

    @Test
    fun startActivity_activity_notNull() {
        activityRule.scenario.onActivity { activity ->
            assertThat(activity, `is`(notNullValue()))
        }
    }

    @Test
    fun startActivity_installSplash_isNotNull() {
        activityRule.scenario?.run {
            moveToState(CREATED)
            onActivity { activity ->
                val splash = activity.installSplashScreen()
                assertThat(splash, `is`(notNullValue()))
            }
        }
    }

}