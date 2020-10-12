package dev.harivignesh.configuration.ui.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.drawLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.harivignesh.configuration.ui.R
import dev.harivignesh.configuration.ui.picker.Account

/**
 * Created by Hari on 08/10/2020.
 * Compose views
 */
@Composable
fun accountSelector(
    fromAccountName: String,
    toAccountName: String,
    fromAccountNumber: String,
    toAccountNumber: String,
    onFromSelected: (((Account) -> Unit) -> Unit)?,
    onToSelected: (((Account) -> Unit) -> Unit)?
) {
    ConstraintLayout(modifier = Modifier.padding(16.dp)) {
        val (image, cards) = createRefs()
        val fromAccount = remember { mutableStateOf(Account(fromAccountName, fromAccountNumber)) }
        val toAccount = remember { mutableStateOf(Account(toAccountName, toAccountNumber)) }

        Column(modifier = Modifier.constrainAs(cards) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Card(
                border = BorderStroke(1.dp, colorResource(id = R.color.colorPrimaryDark)),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.fillMaxWidth().fillMaxWidth().clickable(onClick = {
                    onFromSelected?.invoke { fromAccount.value = it }
                })
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Column {
                        Text(
                            text = fromAccount.value.accountName,
                            style = MaterialTheme.typography.subtitle1,
                        )
                        Text(
                            text = fromAccount.value.accountNumber,
                            style = MaterialTheme.typography.subtitle2,
                            color = colorResource(id = R.color.textColorSecondary)
                        )
                    }
                }
            }

            Card(
                border = BorderStroke(1.dp, colorResource(id = R.color.colorPrimaryDark)),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.padding(top = 8.dp).fillMaxWidth().clickable(onClick = {
                    onToSelected?.invoke { toAccount.value = it }
                })
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Column {
                        Text(
                            text = toAccount.value.accountName,
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(
                            text = toAccount.value.accountNumber,
                            style = MaterialTheme.typography.subtitle2,
                            color = colorResource(id = R.color.textColorSecondary)
                        )
                    }
                }
            }
        }

        Card(
            shape = CircleShape,
            border = BorderStroke(1.dp, colorResource(id = R.color.colorPrimaryDark)),
            modifier = Modifier.width(32.dp).height(32.dp).constrainAs(image) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Box(modifier = Modifier.padding(8.dp), alignment = Alignment.Center) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_baseline_double_arrow_24),
                    tint = colorResource(id = R.color.textColorSecondary)
                )
            }

        }

    }
}

@Preview("Account Selector")
@Composable
fun previewAccountSelector() {
    accountSelector(
        fromAccountName = "Sample Bank",
        toAccountName = "Sample Bank",
        fromAccountNumber = "Sample Bank Number",
        toAccountNumber = "Sample Bank Number",
        onFromSelected = {},
        onToSelected = {}
    )
}