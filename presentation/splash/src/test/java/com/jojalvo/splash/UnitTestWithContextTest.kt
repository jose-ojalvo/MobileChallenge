package com.jojalvo.splash

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 *   @author jojalvo
 *   @since 19/4/23
 *   @email josealejandro025@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class UnitTestWithContextTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun context_packageName_containsSplashPackage() {
        assertThat(context.packageName).contains("com.jojalvo.splash")
    }
}