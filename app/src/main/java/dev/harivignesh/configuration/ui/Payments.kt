package dev.harivignesh.configuration.ui

import androidx.compose.foundation.layout.Column
import dev.harivignesh.configuration.ui.compose.accountSelector
import dev.harivignesh.configuration.ui.compose.amountView
import dev.harivignesh.configuration.ui.configuration.ComposeLayout
import dev.harivignesh.configuration.ui.configuration.PaymentsConfiguration
import dev.harivignesh.configuration.ui.configuration.Step
import dev.harivignesh.configuration.ui.picker.AccountPicker

/**
 * Created by Hari on 06/10/2020.
 * Payments configuration
 */
object Payments {

    val config = PaymentsConfiguration {
        navGraph = R.navigation.navigation_payment
        step = Step {
            title = "Transfer Funds"
            layout = { fragmentManager ->
                ComposeLayout {
                    content = {
                        Column {
                            accountSelector(
                                fromAccountName = "N26",
                                fromAccountNumber = "NL 0000 0000 0000 0000 00",
                                toAccountName = "Bunq",
                                toAccountNumber = "NL 0000 0000 0000 0000 00",
                                onFromSelected = { listener ->
                                    AccountPicker { listener(it) }
                                        .show(fragmentManager, "account-picker-from")
                                },
                                onToSelected = { listener ->
                                    AccountPicker { listener(it) }
                                        .show(fragmentManager, "account-picker-to")
                                }
                            )

                            amountView()
                        }
                    }
                }
//                StackLayout {
//                    stacks = listOf(
//                        AccountSelectorView_().apply {
//                            id(1)
//                            fromAccountName("N26")
//                            fromAccountNumber("NL 0000 0000 0000 0000 00")
//                            toAccountName("Bunq")
//                            toAccountNumber("NL 0000 0000 0000 0000 00")
//                            onFromSelected { listener ->
//                                AccountPicker { listener(it) }
//                                    .show(fragmentManager, "account-picker-from")
//                            }
//                            onToSelected { listener ->
//                                AccountPicker { listener(it) }
//                                    .show(fragmentManager, "account-picker-to")
//                            }
//                        },
//                        AmountView_().apply { id(2) }
//                    )
//                }
            }
        }
    }
}