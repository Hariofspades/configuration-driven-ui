package dev.harivignesh.configuration.ui.epoxy.view

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.textfield.TextInputEditText
import dev.harivignesh.configuration.ui.R
import dev.harivignesh.configuration.ui.epoxy.KotlinEpoxyHolder

/**
 * Created by Hari on 06/10/2020.
 * Epoxy class for amount view
 */
@EpoxyModelClass(layout = R.layout.view_amount)
abstract class AmountView: EpoxyModelWithHolder<AmountView.Holder>() {

    override fun bind(holder: Holder) {}

    inner class Holder: KotlinEpoxyHolder() {
        val amountView by bind<TextInputEditText>(R.id.amountView)
    }
}