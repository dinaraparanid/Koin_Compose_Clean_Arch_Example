package com.paranid5.koinmvvvmtest_compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.paranid5.koinmvvvmtest_compose.ui_handlers.UIHandler
import com.paranid5.koinmvvvmtest_compose.view_models.StateChangedCallback
import kotlinx.coroutines.launch

@Composable
fun <H : UIHandler> OnUIStateChanged(
    lifecycleOwner: LifecycleOwner,
    callback: StateChangedCallback<H>
) = DisposableEffect(lifecycleOwner) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) { callback() }
    }

    onDispose { callback.onDispose?.invoke(callback.uiHandler) }
}