package com.paranid5.koinmvvvmtest_compose.view_models

import com.paranid5.koinmvvvmtest_compose.ui_handlers.UIHandler
import kotlinx.coroutines.flow.StateFlow

class StateChangedCallback<H : UIHandler>(
    val uiHandler: H,
    val state: StateFlow<Boolean>,
    val onDispose: (H.() -> Unit)? = null,
    val callback: suspend H.() -> Unit,
) {
    suspend operator fun invoke() {
        state.collect { isChanged -> if (isChanged) callback(uiHandler) }
    }
}