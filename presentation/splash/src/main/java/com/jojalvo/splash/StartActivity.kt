package com.jojalvo.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

/**
 *   @author jojalvo
 *   @since 1/4/23
 *   @email josealejandro025@gmail.com
 */
@AndroidEntryPoint
class StartActivity: ComponentActivity() {

    private val viewModel by viewModels<StartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.startOnBoarding.collectLatest {
                    delay(2.seconds)
                    
                }
            }
        }
    }

}