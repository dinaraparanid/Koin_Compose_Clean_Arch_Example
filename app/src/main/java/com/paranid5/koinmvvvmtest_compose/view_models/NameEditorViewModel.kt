package com.paranid5.koinmvvvmtest_compose.view_models

import androidx.lifecycle.SavedStateHandle
import com.paranid5.koinmvvvmtest_compose.ui_handlers.NameEditorUIHandler
import com.paranid5.koinmvvvmtest_compose.view_models.presenters.NameEditorPresenter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class NameEditorViewModel(savedStateHandle: SavedStateHandle) :
    ObservableViewModel<NameEditorPresenter, NameEditorUIHandler>() {
    private companion object {
        private const val CURRENT_TEXT = "currentText"
    }

    override val presenter by inject<NameEditorPresenter> {
        parametersOf(savedStateHandle.getStateFlow<String?>(CURRENT_TEXT, null).value)
    }

    override val handler by inject<NameEditorUIHandler>()

    private val _isConfirmNameButtonPressedState = MutableStateFlow(false)
    val isConfirmNameButtonPressedState = _isConfirmNameButtonPressedState.asStateFlow()

    fun onConfirmNameButtonPressed() {
        _isConfirmNameButtonPressedState.value = true
    }

    fun finishNameSetting() {
        _isConfirmNameButtonPressedState.value = false
    }
}