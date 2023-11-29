package com.example.compose.day567

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.day567.components.CustomInputField
import com.example.compose.day567.components.RoundedIconButton
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.day567.utils.calculateTipAmount
import com.example.compose.day567.utils.calculateTotalPerPerson

class TipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview
@Composable
fun MainContent() {
    Column() {
        BillForm() { billAmt ->
            Log.d("AMT", "MainContent:$billAmt ")
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(modifier: Modifier = Modifier, onValChange: (String) -> Unit) {
    val totalBillState = remember {
        mutableStateOf("")
    }
    val isValid = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val tipPercentageState = remember {
        mutableStateOf(0f)
    }
    val splitByState = remember {
        mutableStateOf(1)
    }
    val tipAmountState = remember {
        mutableStateOf(0.0)
    }

    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }
    TopHeaderPart(totalPerPersonState.value)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp), shape = RoundedCornerShape(corner = CornerSize(size = 12.dp)),
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colors.background)
    ) {
        Column() {
            CustomInputField(
                modifier = Modifier.fillMaxWidth(),
                valueState = totalBillState,
                isSingleLine = true,
                enabled = true,
                labelId = "Total Bill",
                onAction = KeyboardActions {
                    if (!isValid) return@KeyboardActions
                    onValChange.invoke(totalBillState.value)
                    keyboardController?.hide()
                })
//            if (isValid) {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Split", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.width(200.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    RoundedIconButton(
                        modifier = Modifier.size(30.dp),
                        icon = Icons.Default.Add,
                        onClickListener = {
                            splitByState.value += 1
                        })
                    Text(
                        text = splitByState.value.toString(), modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    )
                    RoundedIconButton(
                        modifier = Modifier.size(30.dp),
                        icon = Icons.Default.Remove,
                        onClickListener = {
                            if (splitByState.value > 1) {
                                splitByState.value -= 1
                            } else {
                                splitByState.value = 1
                            }
                        })
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            {
                Text(text = "Tip", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.width(200.dp))
                Text(text = "$ ${tipAmountState.value}", style = MaterialTheme.typography.body1)
            }
            Column(
                modifier = Modifier.padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = tipPercentageState.value.times(100).toInt().toString())
                Slider(value = tipPercentageState.value, onValueChange = { newVal ->
                    tipPercentageState.value = newVal
                    tipAmountState.value =
                        calculateTipAmount(
                            totalBillState.value.toDouble(),
                            tipPercentageState.value.times(100).toInt()
                        )
                    totalPerPersonState.value = calculateTotalPerPerson(
                        totalBill = totalBillState.value.toDouble(),
                        splitBy = splitByState.value,
                        tipPercentage = tipPercentageState.value.times(100).toInt()
                    )
                })
            }
//            } else {
//                Box() {}
//            }
        }
    }
}


@Composable
fun TopHeaderPart(totalPerPerson: Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(150.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(size = 12.dp))),
        color = Color.Magenta.copy(alpha = 0.2f)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person", style = MaterialTheme.typography.h5)
            Text(
                text = "$$total",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
