package dev.harivignesh.configuration.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import dev.harivignesh.configuration.ui.R

/**
 * Created by Hari on 08/10/2020.
 * Compose views
 */
@Composable
@Preview(name = "Account Selector")
fun accountSelector() {
    ConstraintLayout(modifier = Modifier.padding(16.dp)) {
        val (image, cards) = createRefs()
        Column(modifier = Modifier.constrainAs(cards) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, colorResource(id = R.color.colorPrimaryDark)),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Column {
                        Text(text = "N26", style = MaterialTheme.typography.subtitle1)
                        Text(
                            text = "NL 0000 0000 0000 0000 00",
                            style = MaterialTheme.typography.subtitle2,
                            color = colorResource(id = R.color.textColorSecondary)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier.padding(top = 8.dp).fillMaxWidth(),
                border = BorderStroke(1.dp, colorResource(id = R.color.colorPrimaryDark)),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Column {
                        Text(text = "N26", style = MaterialTheme.typography.subtitle1)
                        Text(
                            text = "NL 0000 0000 0000 0000 00",
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
            Image(
                asset = vectorResource(id = R.drawable.ic_baseline_double_arrow_24),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}