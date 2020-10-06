package dev.harivignesh.configuration.ui.epoxy.view

import android.view.View
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.textview.MaterialTextView
import dev.harivignesh.configuration.ui.R
import dev.harivignesh.configuration.ui.epoxy.KotlinEpoxyHolder
import dev.harivignesh.configuration.ui.picker.Account

/**
 * Created by Hari on 06/10/2020.
 * Epoxy model for account selector
 */
@EpoxyModelClass(layout = R.layout.view_account_selector)
abstract class AccountSelectorView: EpoxyModelWithHolder<AccountSelectorView.Holder>() {

    @EpoxyAttribute lateinit var fromAccountName: String
    @EpoxyAttribute lateinit var toAccountName: String

    @EpoxyAttribute lateinit var fromAccountNumber: String
    @EpoxyAttribute lateinit var toAccountNumber: String

    @EpoxyAttribute var onFromSelected: (((Account) -> Unit) -> Unit)? = null
    @EpoxyAttribute var onToSelected: (((Account) -> Unit) -> Unit)? = null

    override fun bind(holder: Holder) {
        holder.apply {
            fromAccountNameView.text = fromAccountName
            toAccountNameView.text = toAccountName

            fromAccountNumberView.text = fromAccountNumber
            toAccountNumberView.text = toAccountNumber

            fromAccountView.setOnClickListener {
                onFromSelected?.invoke {
                    fromAccountNameView.text = it.accountName
                    fromAccountNumberView.text = it.accountNumber
                }
            }
            toAccountView.setOnClickListener {
                onToSelected?.invoke {
                    toAccountNameView.text = it.accountName
                    toAccountNumberView.text = it.accountNumber
                }
            }
        }
    }

    inner class Holder : KotlinEpoxyHolder() {

        val fromAccountView by bind<CardView>(R.id.fromAccount)
        val toAccountView by bind<CardView>(R.id.toAccount)

        val fromAccountNameView by bind<MaterialTextView>(R.id.fromAccountName)
        val toAccountNameView by bind<MaterialTextView>(R.id.toAccountName)

        val fromAccountNumberView by bind<MaterialTextView>(R.id.fromAccountNumber)
        val toAccountNumberView by bind<MaterialTextView>(R.id.toAccountNumber)
    }

}