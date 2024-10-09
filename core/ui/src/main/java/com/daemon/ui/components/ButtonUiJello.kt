package com.daemon.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daemon.ui.R
import com.daemon.ui.theme.JelloBlueColor
import com.daemon.ui.theme.JelloYellowColor
import com.daemon.ui.theme.JellowRedColor
import com.daemon.ui.theme.TintColor

@Composable
fun ButtonPrimary(
    text: String = "Login Now",
    onClick: () -> Unit = {}
) {
    BaseButtonJello(
        label = text,
        enabled = true,
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        color = ButtonDefaults.buttonColors(
            containerColor = JelloYellowColor,
            contentColor = TintColor,
        ),
        onClick = onClick
    )
}

@Preview
@Composable
fun ButtonPrimaryPreview() {
    ButtonPrimary()
}

@Composable
fun ButtonFacebook(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    BaseButtonWithIcon(
        label = "Sign Up",
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = JelloBlueColor,
        ),
        modifier = modifier,
        onClick = onClick
    )
}

@Preview
@Composable
fun ButtonFacebookPreview() {
    ButtonFacebook()
}

@Composable
fun ButtonGoogle(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    BaseButtonWithIcon(
        label = "Sign Up",
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = JellowRedColor,
        ),
        modifier = modifier,
        onClick = onClick,
        srcIcon = R.drawable.ic_google,
        descIcon = "Google"
    )
}

@Preview
@Composable
fun ButtonGooglePreview() {
    ButtonGoogle()
}















