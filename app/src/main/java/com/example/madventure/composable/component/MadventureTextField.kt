package com.example.madventure.composable.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madventure.ui.theme.Primary
import com.example.madventure.ui.theme.TextFieldColor
import com.example.madventure.ui.theme.gothamProFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MadventureTextField(
    modifier: Modifier = Modifier.size(450.dp, 50.dp),
    startValue: String = "",
    isPassword: Boolean = false,
    placeholder: String = "Email"
) {
    var value by remember { mutableStateOf(startValue) }
    var isActive by remember { mutableStateOf(false) }
    BasicTextField(
        value = value,
        modifier = modifier,
        onValueChange = {
            value = it
        },
        interactionSource = MutableInteractionSource(),
        singleLine = true,
        decorationBox = @Composable { innerTextField ->
            Column {
                if (value.isEmpty()) {
                    Text(
                        text = "Email",
                        style = TextStyle(
                            color = TextFieldColor,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = gothamProFamily
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                } else {
                    isActive = false
                    innerTextField()
                    Spacer(modifier = Modifier.height(5.dp))
                }
                Divider(color = if (isActive) Primary else TextFieldColor, thickness = 2.dp)
            }
        },
        textStyle = TextStyle(
            color = Primary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = gothamProFamily
        ),
        cursorBrush = SolidColor(if (isActive) Primary else TextFieldColor)
    )
}

@Preview(showBackground = true)
@Composable
fun MadventureTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(8.dp)) {
        MadventureTextField(
            startValue = value,
        )
    }
}