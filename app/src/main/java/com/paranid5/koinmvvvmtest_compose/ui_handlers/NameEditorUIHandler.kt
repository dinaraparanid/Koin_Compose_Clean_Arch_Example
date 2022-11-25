package com.paranid5.koinmvvvmtest_compose.ui_handlers

import com.paranid5.koinmvvvmtest_compose.view_models.presenters.NameEditorPresenter

class NameEditorUIHandler(private val emptyNameError: String) : UIHandler {
    fun onConfirmNameButtonPressed(name: String, presenter: NameEditorPresenter) =
        when {
            name.isEmpty() -> presenter.greetingsTextState.value = emptyNameError
            else -> presenter.greetingsTextState.value = "Hello, ${name.trim()}!"
        }
}