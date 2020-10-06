package dev.harivignesh.configuration.ui.configuration

import androidx.annotation.NavigationRes
import dev.drewhamilton.extracare.DataApi

/**
 * Created by Hari on 06/10/2020.
 * Payments configuration
 *
 * Generated using DSL Builder
 * @see "https://plugins.jetbrains.com/plugin/14386-dsl-api-generator"
 *
 * @param navGraph navigation graph to set
 * @param step one step for now, can be list of [Step] for more steps
 */
@DataApi
class PaymentsConfiguration private constructor(@NavigationRes val navGraph: Int, val step: Step) {

    /**
     * A builder for this configuration class
     *
     * Should be directly used by Java consumers. Kotlin consumers should use DSL function
     */
    class Builder {

        var navGraph: Int = 0
            @JvmSynthetic set

        var step: Step = Step { }
            @JvmSynthetic set

        fun setNavGraph(navGraph: Int) = apply { this.navGraph = navGraph }

        fun setStep(step: Step) = apply { this.step = step }

        fun build() = PaymentsConfiguration(navGraph, step)

    }
}

/**
 * DSL to create [PaymentsConfiguration]
 */
@JvmSynthetic
@Suppress("FunctionName")
fun PaymentsConfiguration(block: PaymentsConfiguration.Builder.() -> Unit) =
    PaymentsConfiguration.Builder().apply(block).build()
