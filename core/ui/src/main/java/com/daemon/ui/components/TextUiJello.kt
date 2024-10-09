package com.daemon.ui.components

import android.widget.CheckBox
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daemon.ui.theme.PrimaryColor
import com.daemon.ui.theme.VeryLightGrey
import com.daemon.ui.theme.VividMagenta

@Composable
fun JelloTextHeader(
    text: String = "Welcome to Login",
    color: Color = Color.Black,
    modifier: Modifier = Modifier.padding(16.dp)
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Left,
        ),
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
fun JelloTextHeaderPreview() {
    JelloTextHeader(
        "Nama saya Adhri, saya berasal dari Merauke"
    )
}

@Composable
fun JelloTextRegularWithClick(
    text: String = "Please fill E-mail & Password to Login your app account. ",
    textClick: String = "Sign Up",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier.padding(16.dp)
) {

    val anotateText = buildAnnotatedString { 
        append(text)

        pushStringAnnotation(
            tag = "TEXT_CLICKED",
            annotation = textClick
        )
        withStyle(
            style = SpanStyle(
                color = VividMagenta,
                fontWeight = FontWeight.Bold,
            )
        ) {
            append(textClick)
        }
        pop()
    }

    ClickableText(
        text = anotateText,
        modifier = modifier,
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
        ),
        onClick = { offset ->
            anotateText.getStringAnnotations(
                tag = "TEXT_CLICKED",
                start = offset,
                end = offset,
            ).firstOrNull()?.let {
                onClick()
            }
        }
    )
}

@Preview
@Composable
fun JelloTextRegularWithClickPreview() {
    JelloTextRegularWithClick()
}

@Composable
fun JelloTextRegular(
    text: String = "Email",
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            textAlign = TextAlign.Left
        ),
        color = color,
        modifier = modifier
    )
}

@Preview
@Composable
fun JelloTextRegularPreview() {
    JelloTextRegular(
        text = "Email",
    )
}

@Composable
fun JelloTextViewRow(
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    onTextClick: () -> Unit = {},
    textLeft: String = "Remember me",
    textRight: String = "Forgot password?"
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        JelloCheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            label = textLeft,
            modifier = Modifier.padding(vertical = 8.dp).weight(1f)
        )

        val annotationString = buildAnnotatedString {
            append(textRight)
        }

        ClickableText(
            text = annotationString,
            onClick = {
                onTextClick
            },
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = PrimaryColor
            )
        )
    }
}

@Preview
@Composable
fun JelloTextViewRowPreview() {
    JelloTextViewRow()
}



