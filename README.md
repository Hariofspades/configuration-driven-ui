# configuration-driven-ui
Android: Configuration driven UI using Epoxy and migrating to Compose

## Configuration driven UI with Epoxy
```kotlin
PaymentsConfiguration {
        navGraph = R.navigation.navigation_payment
        step = Step {
            title = "Transfer Funds"
            layout = { fragmentManager ->
                StackLayout {
                    stacks = listOf(
                        AccountSelectorView_().apply {
                            id(1)
                            fromAccountName("N26")
                            fromAccountNumber("NL 0000 0000 0000 0000 00")
                            toAccountName("Bunq")
                            toAccountNumber("NL 0000 0000 0000 0000 00")
                            onFromSelected { listener ->
                                AccountPicker { listener(it) }
                                    .show(fragmentManager, "account-picker-from")
                            }
                            onToSelected { listener ->
                                AccountPicker { listener(it) }
                                    .show(fragmentManager, "account-picker-to")
                            }
                        },
                        AmountView_().apply { id(2) }
                    )
                }
            }
        }
    }
}
```
## Configuration driven UI with Jetpack Compose
```kotlin
PaymentsConfiguration {
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
            }
        }
    }
}
```
