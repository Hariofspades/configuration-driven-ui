package dev.harivignesh.configuration.ui.configuration

import androidx.compose.runtime.Composable
import com.airbnb.epoxy.EpoxyModel
import dev.drewhamilton.extracare.DataApi

/**
 * Created by Hari on 07/10/2020.
 * Collection of layouts
 */
sealed class StepLayout {

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
    class StackLayout private constructor(val stacks: List<EpoxyModel<*>>): StepLayout() {

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
     * Created by Hari on 06/10/2020.
     * Stack Layout for epoxy lists
     *
     * Generated using DSL Builder
     * @see "https://plugins.jetbrains.com/plugin/14386-dsl-api-generator"
     *
     * @param stacks list of epoxy models
     */
    @DataApi
    class ComposeLayout private constructor(
        val content: @Composable () -> Unit
    ): StepLayout() {

        /**
         * A builder for this configuration class
         *
         * Should be directly used by Java consumers. Kotlin consumers should use DSL function
         */
        class Builder {

            var content: @Composable () -> Unit = {}

            fun setContent(content: @Composable () -> Unit) = apply { this.content = content }

            fun build() = ComposeLayout(content)
        }
    }
}

/**
 * DSL to create [StackLayout]
 */
@JvmSynthetic
@Suppress("FunctionName")
fun StackLayout(block: StepLayout.StackLayout.Builder.() -> Unit) =
    StepLayout.StackLayout.Builder().apply(block).build()

/**
 * DSL to create [ComposeLayout]
 */
@JvmSynthetic
@Suppress("FunctionName")
fun ComposeLayout(block: StepLayout.ComposeLayout.Builder.() -> Unit) =
    StepLayout.ComposeLayout.Builder().apply(block).build()