package dev.harivignesh.configuration.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

/**
 * Created by Hari on 06/10/2020.
 * Main screen
 */
class MainActivity : AppCompatActivity() {

    // configuration needs to be injected. This is for demo purpose only
    val configuration = Payments.config

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationGraph()
    }

    private fun setupNavigationGraph() {
        if (configuration.navGraph != 0) {
            val finalHost = NavHostFragment.create(configuration.navGraph)
            supportFragmentManager.beginTransaction()
                .replace(R.id.hostFragment, finalHost)
                .setPrimaryNavigationFragment(finalHost)
                .commit()
        } else throw IllegalArgumentException(
            "Unable to find the navigation graph - ${configuration.navGraph}"
        )
    }
}