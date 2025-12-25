package com.ext.recyclerviewanimators.animator

import androidx.recyclerview.widget.RecyclerView
import com.ext.recyclerviewanimators.utils.AnimatorUtils

class FadeInAnimator(
    private val durationMillis: Long = 300,
    private val delayMillis: Long = 0
) : BaseItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        reset(holder)
        holder.itemView.alpha = 0f

        holder.itemView.animate()
            .alpha(1f)
            .setStartDelay(delayMillis)
            .setDuration(durationMillis)
            .start()

        return true
    }
}

