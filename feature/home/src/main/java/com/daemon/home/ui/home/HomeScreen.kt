package com.daemon.home.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daemon.ui.R
import com.daemon.ui.components.BannerUiJello
import com.daemon.ui.components.JelloImageViewClick
import com.daemon.ui.components.JelloImageViewPhotoRoundedURl
import com.daemon.ui.components.JelloTextRegular
import com.daemon.ui.theme.LightBlue
import com.daemon.ui.theme.LightGrayBlue
import com.daemon.ui.theme.StrongBlue
import com.daemon.ui.theme.VividMagenta

@Composable
fun HomeScreen() {
    val images: List<Painter> = listOf(
        painterResource(R.drawable.slider_1),
        painterResource(R.drawable.slider_2),
    )

    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = StrongBlue)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ) {
            Card (
                modifier = Modifier.weight(1f)
            ) {
                Row (
                    modifier = Modifier.background(color = LightBlue)
                        .fillMaxWidth()
                ) {
                    JelloImageViewClick(
                        imageVector = Icons.Outlined.Search,
                    )
                    JelloTextRegular(
                        text = "Cari barang Kamu disini",
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            JelloImageViewClick(
                imageVector = Icons.Outlined.ShoppingCart,
            )
        }

        BannerUiJello(
            bannerImage = images
        )

        val temp = listOf(
            ProductItem(
                title = "CATEGORIES",
                subItems = listOf(
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                )
            ),
            ProductItem(
                title = "NEW PRODUCT",
                subItems = listOf(
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                )
            )
        )

        ItemProductHomeList(temp)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

data class ProductItem (
    val title: String,
    val subItems: List<String> = emptyList()
)

@Composable
fun ItemProductHomeList(items: List<ProductItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(Color.White)
            .padding(25.dp),
    ) {
        items(items) { item ->
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                )

                val annotationString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = VividMagenta,
                        )
                    ) {
                        append("SEE ALL")
                    }
                }

                ClickableText(
                    text = annotationString
                ) {

                }

//                    Text(
//                        text = "SEE ALL",
//                        style = TextStyle(
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Medium,
//                            color = VividMagenta
//                        )
//                    )
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (item.subItems.isNotEmpty()) {
                SubItemList(item.subItems)
            }
        }
    }
}

@Composable
fun SubItemList(subItems: List<String>) {
    LazyRow (modifier = Modifier.padding()) {
        items(subItems) { item ->
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(90.dp)
                    .padding(end = 16.dp, bottom = 16.dp)
                    .clickable {  },
                colors = CardDefaults.cardColors(
                    containerColor = LightGrayBlue,
                )
            ) {
                JelloImageViewPhotoRoundedURl(
                    url = item,
                    description = "Image ke ${item}"
                )
            }
        }
    }
}
