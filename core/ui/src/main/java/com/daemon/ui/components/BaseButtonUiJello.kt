package com.daemon.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daemon.ui.R
import com.daemon.ui.theme.TintColor

@Composable
fun BaseButtonJello(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    label: String = "Default Text",
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(10.dp),
    color: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White,
    ),
    textColor: Color = TintColor
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        enabled = enabled,
        colors = color
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            ),
            color = textColor
        )
    }
}

@Preview
@Composable
fun BaseButtonJelloPreview() {
    BaseButtonJello()
}

@Composable
fun BaseButtonWithIcon(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    label: String = "Default Text",
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White,
    ),
    color: Color = Color.White,
    srcIcon: Int = R.drawable.ic_facebook,
    descIcon: String = "Facebook",
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = srcIcon),
                contentDescription = descIcon,
                modifier = Modifier.padding(end = 8.dp).size(24.dp),
                tint = color
            )

            Text(
                text = label,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}

@Preview
@Composable
fun BaseButtonWithIconPreview() {
    BaseButtonWithIcon()
}
