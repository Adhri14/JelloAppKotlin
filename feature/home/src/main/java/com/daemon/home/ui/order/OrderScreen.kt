package com.daemon.home.ui.order

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daemon.home.R
import com.daemon.ui.components.JelloImageViewClick
import com.daemon.ui.components.JelloImageViewPhotoRoundedURl
import com.daemon.ui.components.JelloTextRegular
import com.daemon.ui.theme.JellowOrangeColor
import com.daemon.ui.theme.LightGrayBlue
import com.daemon.ui.theme.LigthGray
import com.daemon.ui.theme.SoftLightGray
import com.daemon.ui.theme.VeryLightGrey

@Composable
fun OrderScreen() {
    val items = listOf(
        ProductItem(
            title = "ULTRABOOST 20 SHOES\n" +
                    "NMD_R1 ",
            price = 130,
            rating = 4f,
            image = "https://picsum.photos/200"
        ),
        ProductItem(
            title = "ULTRABOOST 20 SHOES\n" +
                    "NMD_R1 ",
            price = 130,
            rating = 4f,
            image = "https://picsum.photos/200"
        ),
        ProductItem(
            title = "ULTRABOOST 20 SHOES\n" +
                    "NMD_R1 ",
            price = 130,
            rating = 4f,
            image = "https://picsum.photos/200"
        ),
        ProductItem(
            title = "ULTRABOOST 20 SHOES\n" +
                    "NMD_R1 ",
            price = 130,
            rating = 4f,
            image = "https://picsum.photos/200"
        ),
        ProductItem(
            title = "ULTRABOOST 20 SHOES\n" +
                    "NMD_R1 ",
            price = 130,
            rating = 4f,
            image = "https://picsum.photos/200"
        ),
        ProductItem(
            title = "ULTRABOOST 20 SHOES\n" +
                    "NMD_R1 ",
            price = 130,
            rating = 4f,
            image = "https://picsum.photos/200"
        ),
    )

    Scaffold (
        topBar = {
            Column {
                Row (
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Card (
                        modifier = Modifier.weight(1f)
                            .clickable {

                            },
                        colors = CardDefaults.cardColors(
                            containerColor = SoftLightGray,
                        )
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            JelloTextRegular(
                                text = "Cari barang Kamu disini",
                                color = LigthGray
                            )
                            JelloImageViewClick(
                                imageVector = Icons.Outlined.Search,
                                color = LigthGray
                            )
                        }
                    }
                }

                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = VeryLightGrey
                )
            }
        },
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxWidth()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "NEW PRODUCT",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f)
                    ),
                )

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JelloImageViewClick(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                    JelloImageViewClick(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_grid),
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                }
            }

            ItemProductList(items = items)
        }
    }
}

data class ProductItem (
    val title: String,
    val price: Int,
    val rating: Float,
    val image: String
)

@Composable
fun ItemProductList(
    items: List<ProductItem>,
) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(6.dp),
    ) {
        items(items) { item ->
            Card (
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
                    .clickable {

                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                            .background(LightGrayBlue),
                    ) {
                        JelloImageViewPhotoRoundedURl(
                            url = item.image,
                            description = item.title
                        )
                    }
                    Column (
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = item.title,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black.copy(alpha = 0.5f)
                            ),
                            modifier = Modifier.padding(bottom = 7.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "$${item.price}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = JellowOrangeColor
                            ),
                            modifier = Modifier.padding(bottom = 18.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderScreenPreview() {
    OrderScreen()
}