package com.example.android.codelabs.paging.ui.adapter.viewholder

import com.example.android.codelabs.paging.databinding.SeparatorViewItemBinding
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.CommonViewHolder

class SeparatorViewHolder(private val binding: SeparatorViewItemBinding) : CommonViewHolder<UiModel>(binding.root) {

    override fun setData(model: UiModel, clickListener: (UiModel) -> Unit) {
        if (model is UiModel.SeparatorItem) {
            binding.separatorDescription.text = model.description
        }
    }
}