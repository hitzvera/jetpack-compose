package com.hitzvera.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hitzvera.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat
import kotlin.math.ceil
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

@Composable
fun TipTimeScreen(){

    var amountInput by remember { mutableStateOf("0")}
    var tipInput by remember { mutableStateOf("15")}
    var roundUp by remember { mutableStateOf(true)}

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val focusManager = LocalFocusManager.current
    var tip = calculateTip(amount, roundUp,tipInput.toDoubleOrNull() ?: 0.0)

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        EditNumberField(
            R.string.cost_of_service,
            KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            KeyboardActions( onNext = { focusManager.moveFocus(FocusDirection.Down)}),
            amountInput
        ) {
            amountInput = it
        }
        Spacer(Modifier.height(16.dp))
        EditNumberField(
            R.string.calculate_tip,
            KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus()}
            ),
            tipInput
        ) {
            tipInput = it
        }
        RoundTheTipRow(roundUp = roundUp, onRoundUpChanged = {
            roundUp = it
        })
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

    }

}
@VisibleForTesting
internal fun calculateTip(
    amount: Double,
    roundUp: Boolean,
    tipPercent: Double = 15.0
): String {
    var tip = amount / 100 * tipPercent
    if(roundUp)
        tip = ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    value: String,
    onValueChange: (String) -> Unit
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(id = label))},
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Composable
fun RoundTheTipRow(
    modifier: Modifier = Modifier,
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(48.dp)
    ){
        Text(
            text = stringResource(id = R.string.round_up_tip)
        )
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(
                    Alignment.End
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipTimeTheme {
        TipTimeScreen()
    }
}