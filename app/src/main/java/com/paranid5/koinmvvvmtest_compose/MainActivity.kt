package com.paranid5.koinmvvvmtest_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paranid5.koinmvvvmtest_compose.ui.AppBar
import com.paranid5.koinmvvvmtest_compose.ui.NameEditor
import com.paranid5.koinmvvvmtest_compose.ui.theme.KoinMVVVMTest_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KoinMVVVMTest_ComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppBar() }
                ) { padding ->
                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(
                                paddingValues = PaddingValues(
                                    top = padding.calculateTopPadding(),
                                    bottom = padding.calculateBottomPadding()
                                )
                            )
                    ) { NameEditor(Modifier.align(Alignment.Center)) }
                }
            }
        }
    }
}