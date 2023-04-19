package com.jojalvo.testutils

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Rule

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
open class MockkUnitTest {

    open fun onCreate() {}

    open fun onDestroy() {}

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        onCreate()
    }

    @After
    fun tearDown() {
        onDestroy()
        unmockkAll()
        clearAllMocks()
    }

}