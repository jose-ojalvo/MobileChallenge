package com.jojalvo.mcapp.application

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 *   @author jojalvo
 *   @since 19/4/23
 *   @email josealejandro025@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class MCApplicationTest {

    private lateinit var application: MCApplication

    @Before
    fun setup() {
        application = MCApplication()
    }

    @Test
    fun application_checkApplication_notNull() {
        application.onCreate()
        assertThat(ApplicationProvider.getApplicationContext(), `is`(notNullValue()))
    }

}