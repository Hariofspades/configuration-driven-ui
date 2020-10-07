package dev.harivignesh.configuration.ui.configuration

import androidx.fragment.app.FragmentManager
import dev.drewhamilton.extracare.DataApi

/**
 * Created by Hari on 06/10/2020.
 *
 * Generated using DSL Builder
 * @see "https://plugins.jetbrains.com/plugin/14386-dsl-api-generator"
 *
 * @param title title on the toolbar
 * @param layout StackLayout
 * @param onPay Function triggered on pay
 */
@DataApi
class Step private constructor(
    val title: String,
    val layout: (FragmentManager) -> StepLayout,
    val onPay: () -> Unit
) {

    /**
     * A builder for this configuration class
     *
     * Should be directly used by Java consumers. Kotlin consumers should use DSL function
     */
    class Builder {

        var title: String = "Transfer"
            @JvmSynthetic set


        var layout: (FragmentManager) -> StepLayout = { StackLayout {} }
            @JvmSynthetic set


        var onPay: () -> Unit = {}
            @JvmSynthetic set

        fun setTitle(title: String) = apply {
            this.title = title
        }

        fun setLayout(layout: (FragmentManager) -> StepLayout) = apply {
            this.layout = layout
        }

        fun setOnPay(onPay: () -> Unit) = apply {
            this.onPay = onPay
        }

        fun build() = Step(
            title,
            layout,
            onPay
        )

    }
}

/**
 * DSL to create [Step]
 */
@JvmSynthetic
@Suppress("FunctionName")
fun Step(block: Step.Builder.() -> Unit) = Step.Builder().apply(block).build()
