package com.ext.recyclerviewanimators.animator

import androidx.recyclerview.widget.RecyclerView

class ScaleInAnimator(
    private val durationMillis: Long = 300,
    private val delayMillis: Long = 0
) : BaseItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        reset(holder)

        holder.itemView.scaleX = 0.8f
        holder.itemView.scaleY = 0.8f

        holder.itemView.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setStartDelay(delayMillis)
            .setDuration(durationMillis)
            .start()

        return true
    }
}

