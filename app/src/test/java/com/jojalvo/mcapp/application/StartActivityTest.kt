package com.jojalvo.mcapp.application

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jojalvo.framework.base.application.CustomApplicationTest_Application
import com.jojalvo.splash.StartActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
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
class StartActivityTest() {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun startActivity_launchActivity_noReturn() {
        launchActivity<StartActivity>()
    }

}
