package com.paranid5.koinmvvvmtest_compose.view_models.presenters

import kotlinx.coroutines.flow.MutableStateFlow

class NameEditorPresenter(currentText: String?) : BasePresenter {
    val greetingsTextState = MutableStateFlow(currentText)
    val currentTextState = MutableStateFlow(currentText)
}