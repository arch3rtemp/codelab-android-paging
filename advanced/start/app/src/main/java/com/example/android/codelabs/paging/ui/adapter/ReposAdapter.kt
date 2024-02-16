/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.paging.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.viewbinding.ViewBinding
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.CommonViewHolder
import com.example.android.codelabs.paging.ui.common.ItemDrawer

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter(
    private val drawers: List<ItemDrawer<*, *>>
) : PagingDataAdapter<UiModel, CommonViewHolder<ViewBinding, UiModel>>(ItemDrawerDiffUtil(drawers)) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)

        return drawers
            .find { drawer -> drawer.isProperItem(requireNotNull(item)) }
            ?.getLayoutId()
            ?: throw IllegalArgumentException("View type not found: $item")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<ViewBinding, UiModel> {
        val inflater = LayoutInflater.from(parent.context)
        return drawers
            .find { drawer -> drawer.getLayoutId() == viewType }
            ?.getViewHolder(inflater, parent)
            ?.let { drawer -> drawer as CommonViewHolder<ViewBinding, UiModel> }
            ?: throw IllegalArgumentException("View type not found: $viewType")
    }

    override fun onBindViewHolder(holder: CommonViewHolder<ViewBinding, UiModel>, position: Int) {
        holder.onBind(requireNotNull(getItem(position)))
    }
}
