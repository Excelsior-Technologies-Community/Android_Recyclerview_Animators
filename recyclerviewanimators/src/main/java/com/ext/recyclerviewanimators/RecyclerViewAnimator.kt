package com.ext.recyclerviewanimators

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.ext.recyclerviewanimators.animator.FadeInAnimator
import com.ext.recyclerviewanimators.animator.ScaleInAnimator
import com.ext.recyclerviewanimators.animator.SlideInBottomAnimator

class RecyclerViewAnimator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        if (attrs != null) {
            applyAttributes(context, attrs)
        }
    }

    private fun applyAttributes(context: Context, attrs: AttributeSet) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.RecyclerViewAnimator)

        val animatorType =
            typedArray.getInt(R.styleable.RecyclerViewAnimator_ra_animatorType, 0)

        val duration =
            typedArray.getInt(R.styleable.RecyclerViewAnimator_ra_duration, 300).toLong()

        val delay =
            typedArray.getInt(R.styleable.RecyclerViewAnimator_ra_delay, 0).toLong()

        val distance =
            typedArray.getDimension(
                R.styleable.RecyclerViewAnimator_ra_distance,
                60f
            )

        typedArray.recycle()

        val animator = when (animatorType) {
            1 -> SlideInBottomAnimator(distance, duration, delay)
            2 -> ScaleInAnimator(duration, delay)
            else -> FadeInAnimator(duration, delay)
        }

        itemAnimator = animator

        (itemAnimator as? SimpleItemAnimator)
            ?.supportsChangeAnimations = false
    }
}
