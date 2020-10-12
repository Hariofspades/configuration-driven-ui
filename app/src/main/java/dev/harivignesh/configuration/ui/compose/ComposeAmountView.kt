package dev.harivignesh.configuration.ui.compose

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.harivignesh.configuration.ui.R

/**
 * Created by Hari on 09/10/2020.
 * Compose view for amount
 */
@Composable
@Preview("Amount View")
fun amountView() {
    Box(modifier = Modifier.fillMaxWidth().height(200.dp), alignment = Alignment.Center) {
        val state = state { TextFieldValue(text = "") }
        TextField(
            keyboardType = KeyboardType.Number,
            value = state.value,
            onValueChange = { state.value = it },
            backgroundColor = colorResource(id = R.color.colorPrimary),
            leadingIcon = {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_baseline_euro_24),
                    tint = colorResource(id = R.color.colorAccent)
                )
            },
            placeholder = { Text(text = "0.00", style = MaterialTheme.typography.h3) },
            textStyle = MaterialTheme.typography.h3,
        )
    }
}