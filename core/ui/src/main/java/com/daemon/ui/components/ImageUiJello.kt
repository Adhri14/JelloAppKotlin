package com.daemon.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun JelloImageViewClick(
    modifier: Modifier = Modifier.size(24.dp),
    onClick: () -> Unit = {},
    color: Color = Color.White,
    imageVector: ImageVector = Icons.Sharp.ArrowBack,
    description: String = "Back"
) {
    IconButton(
        onClick = {
            onClick.invoke()
        }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = description,
            tint = color,
            modifier = modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JelloImageViewClickPreview() {
    JelloImageViewClick()
}