package com.example.madventure.composable.component

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.model.ActivationModel
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.ui.theme.Primary
import com.example.madventure.ui.theme.TextFieldColor
import com.example.madventure.ui.theme.gothamProFamily
import kotlinx.coroutines.launch
import kotlin.concurrent.timer

@Composable
fun Activation(
    number: String = "+7 999 223 43 23",
    viewModel: AuthorizationViewModel
) {
    var code by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    val timerValue: Long = viewModel.timerValue.observeAsState(0L).value

    LaunchedEffect(Unit) {
        viewModel.startTimer()
    }

    val scope = rememberCoroutineScope()

    Spacer(modifier = Modifier.height(56.dp))
    Text(
        text = "Activation code was sent to number:\n$number",
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = gothamProFamily,
        color = Color(0xFF666666),
        textAlign = TextAlign.Center,
        lineHeight = 29.sp
    )
    val codeStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = gothamProFamily,
        color = Color(0xFF666666),
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(40.dp))
    BasicTextField(
        value = code,
        onValueChange = {
            code = it
            if (code.length == 4) {
                focusManager.clearFocus()
                viewModel.activation(ActivationModel(code))
            }
        },
        decorationBox = { innerTextField ->
            Column {
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (code.isNotEmpty()) code[0].toString() else "",
                            style = codeStyle
                        )
                        Divider(
                            color = TextFieldColor,
                            thickness = 2.dp,
                            modifier = Modifier.width(38.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (code.length > 1) code[1].toString() else "",
                            style = codeStyle
                        )
                        Divider(
                            color = TextFieldColor,
                            thickness = 2.dp,
                            modifier = Modifier.width(38.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (code.length > 2) code[2].toString() else "",
                            style = codeStyle
                        )
                        Divider(
                            color = TextFieldColor,
                            thickness = 2.dp,
                            modifier = Modifier.width(38.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (code.length > 3) code[3].toString() else "",
                            style = codeStyle
                        )
                        Divider(
                            color = TextFieldColor,
                            thickness = 2.dp,
                            modifier = Modifier.width(38.dp)
                        )
                    }
                }
            }
        },
        singleLine = true,
        textStyle = TextStyle(
            color = Primary,
            fontFamily = gothamProFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        modifier = Modifier.focusRequester(focusRequester),
        cursorBrush = SolidColor(Primary)
    )
    Spacer(modifier = Modifier.height(46.dp))

    Text(
        text = "$timerValue sec",
        style = codeStyle
    )

    Spacer(modifier = Modifier.height(26.dp))
    Text(
        text = "Send code again",
        style = codeStyle,
        color = if (timerValue == 0L) Primary else codeStyle.color,
        modifier = if (timerValue == 0L) Modifier.clickable {
            viewModel.startTimer()
            code = ""
        } else Modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ActivationPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Activation(viewModel = AuthorizationViewModel(AuthorizationModel()))
        }
    }
}