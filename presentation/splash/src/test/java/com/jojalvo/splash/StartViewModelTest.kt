package com.jojalvo.splash

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.jojalvo.testutils.MockkUnitTest
import com.jojalvo.usecase.onboarding.ReadOnBoarding
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 *   @author jojalvo
 *   @since 19/4/23
 *   @email josealejandro025@gmail.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class StartViewModelTest : MockkUnitTest() {

    @RelaxedMockK
    lateinit var readOnBoarding: ReadOnBoarding

    @SpyK
    @InjectMockKs
    lateinit var viewModel: StartViewModel

    @Test
    fun verify_startViewModel_callReadOnBoarding() = runTest {
        viewModel.apply {
            init()
        }
        coVerify { readOnBoarding.invoke(Unit) }
        confirmVerified(readOnBoarding)
    }

    @Test
    fun verify_onReadOnBoarding_checkState() = runTest {
        // Arrange
        coEvery { readOnBoarding.invoke(Unit) } returns flow {
            emit(true)
        }
        // Act
        viewModel.apply {
            init()
        }
        // Assert
        viewModel.startOnBoarding.test {
            awaitItem().apply {
                assertThat(this).isNotNull()
                assertThat(this).isInstanceOf(java.lang.Boolean::class.java)
            }
        }
    }

}