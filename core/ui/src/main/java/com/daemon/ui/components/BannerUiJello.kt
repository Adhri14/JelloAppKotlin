package com.daemon.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daemon.ui.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerUiJello(
    bannerImage : List<Painter>,
    onClick: (Int) -> Unit = {}
) {
    val pagerState = rememberPagerState()
    var scope = rememberCoroutineScope()

    Column {
        HorizontalPager(
            count = bannerImage.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth().height(200.dp).background(color = Color.Transparent)
        ) { page ->
            Surface (
                modifier = Modifier.clickable {
                    onClick(page)
                },
                color = Color.Transparent
            ) {
                Image(
                    painter = bannerImage[page],
                    contentDescription = "Banner Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    LaunchedEffect(pagerState) {
        while (true) {
            yield()
            delay(3000)
            scope.launch {
                val nextPage = (pagerState.currentPage + 1) % (bannerImage.size)
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }
}

@Preview
@Composable
fun BannerUiJelloPreview() {
    val images = listOf(
        painterResource(R.drawable.slider_1),
        painterResource(R.drawable.slider_2),
    )
    BannerUiJello(
        bannerImage = images
    )
}