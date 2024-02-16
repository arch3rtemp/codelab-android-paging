package com.example.android.codelabs.paging.ui.adapter.viewholder

import com.example.android.codelabs.paging.databinding.SeparatorViewItemBinding
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.CommonViewHolder

class SeparatorViewHolder(binding: SeparatorViewItemBinding) : CommonViewHolder<SeparatorViewItemBinding, UiModel.SeparatorItem>(binding) {

    override fun onBind(item: UiModel.SeparatorItem) {
        super.onBind(item)

        binding.separatorDescription.text = item.description
    }
}