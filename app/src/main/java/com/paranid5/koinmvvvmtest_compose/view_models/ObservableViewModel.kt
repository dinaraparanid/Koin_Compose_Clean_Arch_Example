package com.paranid5.koinmvvvmtest_compose.view_models

import androidx.lifecycle.ViewModel
import com.paranid5.koinmvvvmtest_compose.ui_handlers.UIHandler
import com.paranid5.koinmvvvmtest_compose.view_models.presenters.BasePresenter
import org.koin.core.component.KoinComponent

abstract class ObservableViewModel<P : BasePresenter, H : UIHandler> : ViewModel(), KoinComponent {
    abstract val presenter: P
    abstract val handler: H
}