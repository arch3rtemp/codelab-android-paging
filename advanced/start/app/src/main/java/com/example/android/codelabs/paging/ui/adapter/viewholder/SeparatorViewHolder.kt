package com.example.android.codelabs.paging.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.CommonViewHolder

class SeparatorViewHolder(view: View) : CommonViewHolder<UiModel>(view) {

    private val description: TextView = view.findViewById(R.id.separator_description)

    override fun setData(model: UiModel, clickListener: (UiModel) -> Unit) {
        if (model is UiModel.SeparatorItem) {
            description.text = model.description
        }
    }

    companion object {
        fun create(parent: ViewGroup): CommonViewHolder<UiModel> {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.separator_view_item, parent, false)
            return SeparatorViewHolder(view)
        }
    }
}