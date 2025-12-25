package com.ext.recyclerviewanimators.animator

import androidx.recyclerview.widget.RecyclerView

class SlideInBottomAnimator(
    private val distance: Float = 60f,
    private val durationMillis: Long = 300,
    private val delayMillis: Long = 0
) : BaseItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        reset(holder)
        holder.itemView.translationY = distance

        holder.itemView.animate()
            .translationY(0f)
            .setStartDelay(delayMillis)
            .setDuration(durationMillis)
            .start()

        return true
    }
}

