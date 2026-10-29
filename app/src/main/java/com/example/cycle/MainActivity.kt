package com.example.cycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.cycle.ui.theme.CycleTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Cycle()
            }
        }
    }
}

@Composable
fun Cycle() {
    var xText by remember { mutableStateOf("") }
    var nText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("Результат появится здесь") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text(

            text = "Циклы",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "S = x/(4^1+5^3) + ... + x/(4^n+5^(n+2))"
        )

        OutlinedTextField(
            value = xText,
            onValueChange = { xText = it },
            label = { Text("Введите x") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = nText,
            onValueChange = { nText = it },
            label = { Text("Введите натуральное n") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )


    }
}

@Preview(showBackground = true)
@Composable
fun CyclePreview() {
    MaterialTheme {
        Cycle()
    }
}