package com.paranid5.koinmvvvmtest_compose.view_models

import com.paranid5.koinmvvvmtest_compose.ui_handlers.UIHandler
import kotlinx.coroutines.flow.StateFlow

class StateChangedCallback<H : UIHandler>(
    private val uiHandler: H,
    val state: StateFlow<Boolean>,
    val callback: suspend H.() -> Unit,
    val onDispose: H.() -> Unit
) {
    suspend operator fun invoke() {
        state.collect { isChanged -> if (isChanged) callback(uiHandler) }
    }
}