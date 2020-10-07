package dev.harivignesh.configuration.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.harivignesh.configuration.ui.configuration.StepLayout
import dev.harivignesh.configuration.ui.epoxy.StepController
import kotlinx.android.synthetic.main.fragment_payment.*

/**
 * A simple [Fragment] subclass.
 *
 */
class PaymentFragment : Fragment(R.layout.fragment_payment) {

    // configuration needs to be injected. This is for demo purpose only
    private val step = Payments.config.step

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.title = step.title
        setupStack()
    }

    private fun setupStack() {
        when (val layout = step.layout(childFragmentManager)) {
            is StepLayout.StackLayout -> {
                val controller = StepController(layout.stacks)
                listView.adapter = controller.adapter
                controller.requestModelBuild()
            }
            else -> {
                // no-op
            }
        }
    }

}