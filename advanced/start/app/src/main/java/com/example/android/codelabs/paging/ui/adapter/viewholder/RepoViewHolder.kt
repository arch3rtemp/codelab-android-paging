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

package com.example.android.codelabs.paging.ui.adapter.viewholder

import android.view.View
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.databinding.RepoViewItemBinding
import com.example.android.codelabs.paging.model.Repo
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.CommonViewHolder

/**
 * View Holder for a [Repo] RecyclerView list item.
 */
class RepoViewHolder(
    binding: RepoViewItemBinding,
    private val clickListener: (UiModel.RepoItem) -> Unit
) : CommonViewHolder<RepoViewItemBinding, UiModel.RepoItem>(binding) {

    init {
        itemView.setOnClickListener { clickListener(item) }
    }

    override fun onBind(item: UiModel.RepoItem) {
        super.onBind(item)

        val repo = item.repo
        binding.apply {
            repoName.text = repo.fullName

            // if the description is missing, hide the TextView
            var descriptionVisibility = View.GONE
            if (repo.description != null) {
                repoDescription.text = repo.description
                descriptionVisibility = View.VISIBLE
            }
            repoDescription.visibility = descriptionVisibility

            repoStars.text = repo.stars.toString()
            repoForks.text = repo.forks.toString()

            // if the language is missing, hide the label and the value
            var languageVisibility = View.GONE
            if (!repo.language.isNullOrEmpty()) {
                val resources = binding.root.context.resources
                repoLanguage.text = resources.getString(R.string.language, repo.language)
                languageVisibility = View.VISIBLE
            }
            repoLanguage.visibility = languageVisibility
        }
    }
}
