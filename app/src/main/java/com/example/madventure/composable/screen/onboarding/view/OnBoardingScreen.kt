package com.example.madventure.composable.screen.onboarding.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.madventure.R
import com.example.madventure.composable.component.PagerItemComponent
import com.example.madventure.composable.screen.onboarding.viewmodel.OnBoardingViewModel
import com.example.madventure.ui.theme.Primary
import com.example.madventure.ui.theme.onBoardingBtn
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    vm: OnBoardingViewModel
) {
    val items = vm.items
    val pagerState = rememberPagerState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background_map),
            contentScale = ContentScale.Crop,
            contentDescription = "background"
        )
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.blur),
                contentDescription = "blur",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 65.dp)
                    .padding(top = 42.dp, bottom = 35.dp)
                    .align(Alignment.TopCenter)
            ) {
                CompositionLocalProvider(
                    LocalOverscrollConfiguration provides null
                ) {
                    HorizontalPager(
                        count = items.size,
                        modifier = Modifier
                            .weight(1f),
                        state = pagerState
                    ) { index ->
                        val page = items[index]
                        PagerItemComponent(pagerItem = page, modifier = Modifier.fillMaxWidth())
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 65.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Skip",
                        style = onBoardingBtn.copy(color = Color.White),
                        modifier = Modifier
                            .clickable {

                            }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        inactiveColor = Color.White,
                        activeColor = Primary
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Next",
                        style = onBoardingBtn,
                        modifier = Modifier
                            .clickable {

                            }
                    )
                }
            }
        }
    }
}