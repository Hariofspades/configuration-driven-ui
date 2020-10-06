package dev.harivignesh.configuration.ui.epoxy

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel

/**
 * Created by Hari on 06/10/2020.
 * Epoxy controller
 */
class StepController(private val list: List<EpoxyModel<*>>): EpoxyController() {

    override fun buildModels() { list.forEach { model -> add(model) } }
}