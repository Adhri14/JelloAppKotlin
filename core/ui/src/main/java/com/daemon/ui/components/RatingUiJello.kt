package com.daemon.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daemon.ui.theme.JelloYellowColor

@Composable
fun RatingUiJello(
    rating: Float,
    onRatingChange: (Float) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for (i in 1 .. 5) {
            val icon = if (i <= rating) {
                Icons.Outlined.Star
            } else {
                Icons.Filled.Star
            }

            Icon(
                imageVector = icon,
                contentDescription = "Star",
                tint = JelloYellowColor,
                modifier = Modifier.size(13.dp)
                    .clickable {
                        onRatingChange(i.toFloat())
                    }
            )
        }
    }
}

@Preview
@Composable
fun RatingUiJelloPreview() {
    RatingUiJello(
        rating = 2.4f
    )
}