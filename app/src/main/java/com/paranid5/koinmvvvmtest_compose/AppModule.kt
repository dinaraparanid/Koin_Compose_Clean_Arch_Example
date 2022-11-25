package com.paranid5.koinmvvvmtest_compose

import com.paranid5.koinmvvvmtest_compose.ui_handlers.NameEditorUIHandler
import com.paranid5.koinmvvvmtest_compose.view_models.NameEditorViewModel
import com.paranid5.koinmvvvmtest_compose.view_models.presenters.NameEditorPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single {
        NameEditorUIHandler(
            emptyNameError = androidContext()
                .resources
                .getString(R.string.no_name_error)
        )
    }

    factory { (currentText: String?) -> NameEditorPresenter(currentText) }
    viewModelOf(::NameEditorViewModel)
}