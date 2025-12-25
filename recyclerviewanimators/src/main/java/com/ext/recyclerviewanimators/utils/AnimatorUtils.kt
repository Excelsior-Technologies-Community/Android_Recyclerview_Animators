package com.ext.recyclerviewanimators.utils

import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.Interpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

object AnimatorUtils {

    private val DEFAULT_INTERPOLATOR = FastOutSlowInInterpolator()

    /**
     * Cancels any running animations and resets the view
     * to a clean state to avoid RecyclerView reuse bugs.
     */
    fun resetView(view: View) {
        view.animate().cancel()
        view.apply {
            alpha = 1f
            translationX = 0f
            translationY = 0f
            scaleX = 1f
            scaleY = 1f
            rotation = 0f
        }
    }

    /**
     * Applies common animation parameters
     */
    fun applyAnimation(
        animator: ViewPropertyAnimator,
        duration: Long,
        delay: Long = 0,
        interpolator: Interpolator? = null
    ): ViewPropertyAnimator {
        return animator
            .setDuration(duration)
            .setStartDelay(delay)
            .setInterpolator(interpolator ?: DEFAULT_INTERPOLATOR)
    }
}
