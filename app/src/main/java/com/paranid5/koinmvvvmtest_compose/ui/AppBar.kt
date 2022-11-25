package com.paranid5.koinmvvvmtest_compose.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paranid5.koinmvvvmtest_compose.R
import com.paranid5.koinmvvvmtest_compose.ui.theme.LocalAppColors

@Composable
fun AppBar() {
    TopAppBar(
        backgroundColor = LocalAppColors.current.value.primary,
        contentPadding = PaddingValues(horizontal = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 20.sp,
            fontFamily = FontFamily.Default,
            color = Color.White
        )
    }
}