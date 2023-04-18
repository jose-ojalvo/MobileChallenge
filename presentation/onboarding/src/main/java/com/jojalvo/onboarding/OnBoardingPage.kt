package com.jojalvo.onboarding

import android.content.Context
import androidx.annotation.DrawableRes
import com.jojalvo.theme.R

/**
 *   @author jojalvo
 *   @since 17/4/23
 *   @email josealejandro025@gmail.com
 */
sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    class First(context: Context) : OnBoardingPage(
        image = R.drawable.ic_app_back,
        title = context.getString(R.string.on_boarding_first_step_title),
        description = context.getString(R.string.on_boarding_first_step_description)
    )

    class Second(context: Context) : OnBoardingPage(
        image = R.drawable.ic_app_back,
        title = context.getString(R.string.on_boarding_first_step_title),
        description = context.getString(R.string.on_boarding_first_step_description)
    )

    class Third(context: Context) : OnBoardingPage(
        image = R.drawable.ic_app_back,
        title = context.getString(R.string.on_boarding_third_step_title),
        description = context.getString(R.string.on_boarding_third_step_description)
    )

}