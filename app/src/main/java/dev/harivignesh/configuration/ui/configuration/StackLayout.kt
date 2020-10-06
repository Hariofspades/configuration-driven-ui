package dev.harivignesh.configuration.ui.configuration

import com.airbnb.epoxy.EpoxyModel
import dev.drewhamilton.extracare.DataApi

/**
 * Created by Hari on 06/10/2020.
 * Stack Layout for epoxy lists
 *
 * Generated using DSL Builder
 * @see "https://plugins.jetbrains.com/plugin/14386-dsl-api-generator"
 *
 * @param stacks list of epoxy models
 */
@DataApi
class StackLayout private constructor(val stacks: List<EpoxyModel<*>>) {

    /**
     * A builder for this configuration class
     *
     * Should be directly used by Java consumers. Kotlin consumers should use DSL function
     */
    class Builder {

        var stacks: List<EpoxyModel<*>> = listOf()
            @JvmSynthetic set

        fun setStacks(stacks: List<EpoxyModel<*>>) = apply { this.stacks = stacks }

        fun build() = StackLayout(stacks)

    }
}

/**
 * DSL to create [StackLayout]
 */
@JvmSynthetic
@Suppress("FunctionName")
fun StackLayout(block: StackLayout.Builder.() -> Unit) =
    StackLayout.Builder().apply(block).build()
