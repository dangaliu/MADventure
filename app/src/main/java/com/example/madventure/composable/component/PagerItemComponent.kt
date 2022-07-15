package com.example.madventure.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madventure.R
import com.example.madventure.model.dto.PagerItem
import com.example.madventure.ui.theme.gothamProFamily

@Composable
fun PagerItemComponent(
    pagerItem: PagerItem,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = pagerItem.imageRes),
            contentDescription = pagerItem.title,
            modifier = Modifier.size(450.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = pagerItem.title,
            fontFamily = gothamProFamily,
            fontSize = 55.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = pagerItem.description,
            fontFamily = gothamProFamily,
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PagerItemComponentPreview() {
    PagerItemComponent(pagerItem = PagerItem(R.drawable.pager_image_1, "Select the quest!", "A huge collection of different quests. Historical, children's, outdoors and many others..."),)
}