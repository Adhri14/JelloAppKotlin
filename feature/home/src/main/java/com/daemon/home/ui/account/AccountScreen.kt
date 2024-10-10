package com.daemon.home.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daemon.home.R
import com.daemon.ui.components.JelloImageViewClick
import com.daemon.ui.components.JelloImageViewPhotoRoundedURl
import com.daemon.ui.components.JelloTextRegular
import com.daemon.ui.theme.JelloBlueColor

@Composable
fun AccountScreen() {
    val scrollState = rememberScrollState()

    val listNavigations = listOf<ListNavigation>(
        ListNavigation(
            label = "Edit Profile",
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_profile)
        ),
        ListNavigation(
            label = "Order History",
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_order_history)
        ),
        ListNavigation(
            label = "Notifications",
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_notification)
        ),
        ListNavigation(
            label = "Cards",
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_card)
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = JelloBlueColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
               modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                JelloImageViewClick(
                    imageVector = Icons.Filled.ArrowBack
                )
                JelloTextRegular(
                    text = "Profile",
                    color = Color.White,
                )
            }

            JelloImageViewClick(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logout),
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JelloImageViewPhotoRoundedURl(
                url = "https://picsum.photos/200",
                description = "Profile Picture",
                modifier = Modifier.size(100.dp).clip(shape = RoundedCornerShape(percent = 100))
            )
            JelloTextRegular(
                text = "Adhri",
                color = Color.White
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
                .weight(1f)
                .clip(shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                .background(color = Color.White)
                .padding(vertical = 30.dp)
        ) {
            for (i in 0 until  listNavigations.size)  {
                ListItemNavigate(
                    text = listNavigations[i].label,
                    imageVector = listNavigations[i].imageVector,
                    descIcon = listNavigations[i].label,
                    onClick = {}
                )
            }
        }
    }
}

data class ListNavigation(
    val label: String,
    val imageVector: ImageVector,
)

@Composable
fun ListItemNavigate(
    text: String = "Edit Profile",
    onClick: () -> Unit = {},
    imageVector: ImageVector = Icons.Filled.KeyboardArrowRight,
    descIcon: String = "Edit Profile"
) {
    Card (
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp)
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = descIcon
                )
                JelloTextRegular(
                    text = text
                )
            }
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Arrow Right"
            )
        }
    }
}

@Preview
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}