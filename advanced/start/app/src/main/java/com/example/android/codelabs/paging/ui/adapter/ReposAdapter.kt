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

import android.util.SparseArray
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.CommonViewHolder
import com.example.android.codelabs.paging.ui.common.ItemDrawer

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter(
    private val clickListener: (UiModel) -> Unit
) : PagingDataAdapter<ItemDrawer, CommonViewHolder<UiModel>>(UI_MODEL_COMPARATOR) {

    private val sparseArray = SparseArray<ItemDrawer>()
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        val key = item?.javaClass.hashCode()
        if (sparseArray.indexOfKey(key) < 0) {
            sparseArray.append(key, item)
        }
        return key
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<UiModel> {
        val drawer = sparseArray[viewType]
        return drawer.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CommonViewHolder<UiModel>, position: Int) {
        getItem(position)?.bind(holder, clickListener)
    }

    companion object {
        private val UI_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<ItemDrawer>() {
            override fun areItemsTheSame(oldItem: ItemDrawer, newItem: ItemDrawer): Boolean {
                return oldItem.compareByItems(newItem)
            }

            override fun areContentsTheSame(oldItem: ItemDrawer, newItem: ItemDrawer): Boolean {
                return oldItem.compareByContent(newItem)
            }
        }
    }
}
