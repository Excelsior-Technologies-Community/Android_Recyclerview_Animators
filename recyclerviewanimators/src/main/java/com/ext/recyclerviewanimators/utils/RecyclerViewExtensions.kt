package com.ext.recyclerviewanimators.utils

import androidx.recyclerview.widget.RecyclerView

/**
 * Runs layout animation on first load
 */
fun RecyclerView.runLayoutAnimation() {
    this.scheduleLayoutAnimation()
    this.adapter?.notifyDataSetChanged()
}
