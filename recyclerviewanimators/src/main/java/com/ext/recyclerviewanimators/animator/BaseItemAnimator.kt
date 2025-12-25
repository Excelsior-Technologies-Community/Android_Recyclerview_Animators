package com.ext.recyclerviewanimators.animator

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.ext.recyclerviewanimators.utils.AnimatorUtils

abstract class BaseItemAnimator : DefaultItemAnimator() {

    protected fun reset(viewHolder: RecyclerView.ViewHolder) {
        AnimatorUtils.resetView(viewHolder.itemView)
    }
}
