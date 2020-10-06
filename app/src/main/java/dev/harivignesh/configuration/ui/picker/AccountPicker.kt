package dev.harivignesh.configuration.ui.picker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.harivignesh.configuration.ui.R
import kotlinx.android.synthetic.main.bottom_sheet_account_picker.*

/**
 * Created by Hari on 06/10/2020.
 * Account picker
 */
class AccountPicker(val onSelected: (Account) -> Unit): BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottom_sheet_account_picker, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountList.adapter = AccountAdapter(list) {
            onSelected(it)
            dismiss()
        }
    }

    companion object {
        val list = listOf(
            Account("N26", "NL 0000 0000 0000 0000 00"),
            Account("Bunq", "NL 0000 0000 0000 0000 00"),
            Account("Monzo", "NL 0000 0000 0000 0000 00"),
            Account("Rabobank", "NL 0000 0000 0000 0000 00"),
            Account("ABN Amro", "NL 0000 0000 0000 0000 00"),
            Account("Revolut", "NL 0000 0000 0000 0000 00")
        )
    }

}