package com.paranid5.koinmvvvmtest_compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.paranid5.koinmvvvmtest_compose.R
import com.paranid5.koinmvvvmtest_compose.view_models.NameEditorViewModel
import com.paranid5.koinmvvvmtest_compose.view_models.StateChangedCallback
import org.koin.androidx.compose.koinViewModel

private inline val CharSequence.isValidName
    get() = isNotEmpty() && all { it.isLetterOrDigit() || it == ' ' } && "  " !in this

@Composable
fun NameEditor(
    modifier: Modifier = Modifier,
    initialText: String = stringResource(R.string.print_your_name),
    hint: String = stringResource(R.string.your_name),
    buttonText: String = stringResource(R.string.confirm),
) {
    val viewModel = koinViewModel<NameEditorViewModel>()

    val greetingsText = viewModel
        .presenter
        .greetingsTextState
        .collectAsState(initial = "")

    val inputText = viewModel
        .presenter
        .currentTextState
        .collectAsState(initial = "")

    val isButtonActive = remember { derivedStateOf { inputText.value?.isValidName == true } }

    val lifecycleOwnerState = rememberUpdatedState(LocalLifecycleOwner.current)

    OnUIStateChanged(
        lifecycleOwner = lifecycleOwnerState.value,
        callback = StateChangedCallback(
            uiHandler = viewModel.handler,
            state = viewModel.isConfirmNameButtonPressedState,
            onDispose = { viewModel.finishNameSetting() }
        ) {
            onConfirmNameButtonPressed(name = inputText.value!!, presenter = viewModel.presenter)
            viewModel.finishNameSetting()
        },
    )

    Column(modifier) {
        Text(
            text = greetingsText.value ?: initialText,
            maxLines = 1,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 15.dp)
        ) {
            TextField(
                value = inputText.value ?: "",
                placeholder = { Text(hint) },
                maxLines = 1,
                onValueChange = { viewModel.presenter.currentTextState.value = it },
                modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Button(
                enabled = isButtonActive.value,
                onClick = viewModel::onConfirmNameButtonPressed,
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
            ) { Text(buttonText) }
        }
    }
}