package com.example.android.codelabs.paging.ui.adapter.drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.adapter.viewholder.RepoViewHolder
import com.example.android.codelabs.paging.ui.common.CommonViewHolder
import com.example.android.codelabs.paging.ui.common.ItemDrawer

class RepoDrawer(override val model: UiModel) : ItemDrawer {
    override fun createViewHolder(parent: ViewGroup): CommonViewHolder<UiModel> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repo_view_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun bind(holder: CommonViewHolder<UiModel>, listener: (UiModel) -> Unit) {
        holder.setData(model, listener)
    }

    override fun compareByItems(newItem: ItemDrawer): Boolean {
        return if (model is UiModel.RepoItem && newItem.model is UiModel.RepoItem) {
            model.repo?.id == (newItem.model as UiModel.RepoItem).repo?.id
        } else false
    }

    override fun compareByContent(newItem: ItemDrawer): Boolean {
        return if (model is UiModel.RepoItem && newItem.model is UiModel.RepoItem) {
            model.repo == (newItem.model as UiModel.RepoItem).repo
        } else false
    }
}