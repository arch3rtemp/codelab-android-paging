package com.example.android.codelabs.paging.ui.adapter.drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.databinding.RepoViewItemBinding
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.adapter.viewholder.RepoViewHolder
import com.example.android.codelabs.paging.ui.common.CommonViewHolder
import com.example.android.codelabs.paging.ui.common.ItemDrawer

class RepoDrawer(
    private val clickListener: (UiModel.RepoItem) -> Unit
) : ItemDrawer<RepoViewItemBinding, UiModel.RepoItem> {

    override fun isProperItem(item: UiModel) = item is UiModel.RepoItem

    override fun getLayoutId() = R.layout.repo_view_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): CommonViewHolder<RepoViewItemBinding, UiModel.RepoItem> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repo_view_item, parent, false)
        val binding = RepoViewItemBinding.bind(view)

        return RepoViewHolder(binding, clickListener)
    }

    override fun getDiffUtil() = object : DiffUtil.ItemCallback<UiModel.RepoItem>() {
        override fun areItemsTheSame(oldItem: UiModel.RepoItem, newItem: UiModel.RepoItem) =
            oldItem.repo.id == newItem.repo.id

        override fun areContentsTheSame(oldItem: UiModel.RepoItem, newItem: UiModel.RepoItem) =
            oldItem.repo == newItem.repo
    }
}