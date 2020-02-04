/*
 * Copyright 2020 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package im.vector.riotx.features.attachments.preview

import android.content.Context
import android.content.Intent
import androidx.appcompat.widget.Toolbar
import im.vector.riotx.R
import im.vector.riotx.core.extensions.addFragment
import im.vector.riotx.core.platform.ToolbarConfigurable
import im.vector.riotx.core.platform.VectorBaseActivity

class AttachmentsPreviewActivity : VectorBaseActivity(), ToolbarConfigurable {

    companion object {

        private const val EXTRA_FRAGMENT_ARGS = "EXTRA_FRAGMENT_ARGS"

        fun newIntent(context: Context, args: AttachmentsPreviewArgs): Intent {
            return Intent(context, AttachmentsPreviewArgs::class.java).apply {
                putExtra(EXTRA_FRAGMENT_ARGS, args)
            }
        }
    }

    override fun getLayoutRes() = R.layout.activity_simple

    override fun initUiAndData() {
        if (isFirstCreation()) {
            val fragmentArgs: AttachmentsPreviewArgs = intent?.extras?.getParcelable(EXTRA_FRAGMENT_ARGS)
                    ?: return
            addFragment(R.id.simpleFragmentContainer, AttachmentsPreviewFragment::class.java, fragmentArgs)
        }
    }

    override fun configure(toolbar: Toolbar) {
        configureToolbar(toolbar)
    }
}
