package dev.harivignesh.configuration.ui

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import dev.harivignesh.configuration.ui.configuration.StepLayout
import dev.harivignesh.configuration.ui.epoxy.StepController

/**
 * A simple [Fragment] subclass.
 *
 */
class PaymentFragment : Fragment(R.layout.fragment_payment) {

    // configuration needs to be injected. This is for demo purpose only
    private val step = Payments.config.step
    private val toolbar by lazy { view?.findViewById<MaterialToolbar>(R.id.toolbar) }
    private val listView by lazy { view?.findViewById<RecyclerView>(R.id.listView) }
    private val composeView by lazy { view?.findViewById<ComposeView>(R.id.composeView) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = step.title
        setupStack()
    }

    private fun setupStack() {
        when (val layout = step.layout(childFragmentManager)) {
            is StepLayout.StackLayout -> {
                composeView?.visibility = View.GONE
                listView?.visibility = View.VISIBLE
                val controller = StepController(layout.stacks)
                listView?.adapter = controller.adapter
                controller.requestModelBuild()
            }
            is StepLayout.ComposeLayout -> {
                listView?.visibility = View.GONE
                composeView?.apply {
                    visibility = View.VISIBLE
                    setContent { layout.content() }
                }
            }
        }
    }

}