package com.paranid5.koinmvvvmtest_compose.ui_handlers

import com.paranid5.koinmvvvmtest_compose.view_models.presenters.NameEditorPresenter

class NameEditorUIHandler : UIHandler {
    fun onConfirmNameButtonPressed(name: String, presenter: NameEditorPresenter) {
        presenter.greetingsTextState.value = "Hello, ${name.trim()}!"
    }
}