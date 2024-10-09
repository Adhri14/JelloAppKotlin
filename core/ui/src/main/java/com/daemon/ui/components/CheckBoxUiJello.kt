package com.daemon.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daemon.ui.theme.VeryLightGrey

@Composable
fun JelloCheckBox(
    label: String = "Remember me",
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier
                .padding(end = 10.dp)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp),
                    color = if (checked) Color.Green else VeryLightGrey // Set border color dynamically
                )
                .size(24.dp), // Adjust the size if needed
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,   // Set color when checked
                uncheckedColor = Color.Transparent, // Set color when unchecked
                checkmarkColor = Color.White  // Color for the checkmark
            )
        )

        Text(
            text = label,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = VeryLightGrey,
            )
        )
    }
}

@Preview
@Composable
fun JelloCheckBoxPreview() {
    JelloCheckBox()
}