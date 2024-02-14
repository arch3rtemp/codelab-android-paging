package com.example.android.codelabs.paging.ui.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CommonViewHolder<Model>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun setData(model: Model, clickListener: (Model) -> Unit)
}
