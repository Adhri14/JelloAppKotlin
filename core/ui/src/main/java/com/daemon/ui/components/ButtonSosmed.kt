package com.daemon.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSosmed() {
    Row (
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonFacebook(
            modifier = Modifier.height(56.dp).weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        ButtonGoogle(
            modifier = Modifier.height(56.dp).weight(1f)
        )
    }
}

@Preview
@Composable
fun ButtonSosmedPreview() {
    ButtonSosmed()
}