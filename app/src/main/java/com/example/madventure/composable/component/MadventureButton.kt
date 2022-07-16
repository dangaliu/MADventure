package com.example.madventure.composable.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.madventure.R
import com.example.madventure.ui.theme.Primary
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun MadventureButton(
    modifier: Modifier = Modifier
        .size(450.dp, 70.dp),
    text: String = "",
    @DrawableRes icon: Int? = null,
    radius: Dp = 35.dp,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = { onClick() },
        shape = RoundedCornerShape(radius),
        modifier = modifier,
        border = null,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Primary,
            contentColor = Color.White
        ),
    ) {
        if (icon != null) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                modifier = Modifier.size(39.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
        } 
        Text(
            text = text,
            style = onBoardingBtn
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0L)
@Composable
fun MadventureButtonPreview() {
    MadventureButton(text = "Sign in")
}