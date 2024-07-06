package com.atakaya.quoteofday.presentation.ui.screens.common.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShareButton(modifier: Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(Icons.Outlined.Share, contentDescription = "share")
    }
}

@Preview
@Composable
private fun ShareButtonPreview() {
    ShareButton(modifier = Modifier, {})
}
