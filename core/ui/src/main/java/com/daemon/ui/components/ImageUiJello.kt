package com.daemon.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.daemon.ui.theme.TintColor

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
            onClick()
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

@Composable
fun JelloImageViewPhotoRoundedURl(
    url: String,
    description: String,
    modifier: Modifier = Modifier.size(100.dp).clip(shape = RoundedCornerShape(8.dp))
) {
    val painter =  rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = url).apply(block = fun ImageRequest.Builder.() {
            crossfade(true).transformations().build()
        }).build()
    )
    val state = painter.state

    Box (contentAlignment = Alignment.Center, modifier = Modifier.padding(10.dp)) {
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            CircularProgressIndicator(
                color = TintColor
            )
        }
        Image(
            painter = painter,
            contentDescription = description,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun JelloImageViewPhotoRoundedURlPreview() {
    JelloImageViewPhotoRoundedURl(
        url = "https://i.pravatar.cc/300",
        description = "Image 1"
    )
}