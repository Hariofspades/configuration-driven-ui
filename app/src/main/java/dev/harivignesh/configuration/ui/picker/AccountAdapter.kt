package dev.harivignesh.configuration.ui.picker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.harivignesh.configuration.ui.R

/**
 * Created by Hari on 06/10/2020.
 * Account adapter
 */
class AccountAdapter(
    private val list: List<Account>,
    private val onClickListener: (Account) -> Unit
) :
    RecyclerView.Adapter<AccountAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val accountName: TextView = itemView.findViewById(R.id.accountName)
        private val accountNumber: TextView = itemView.findViewById(R.id.accountNumber)

        fun bind(data: Account, onClickListener: (Account) -> Unit) {
            accountName.text = data.accountName
            accountNumber.text = data.accountNumber
            itemView.setOnClickListener { onClickListener(data) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_account, parent, false)
    )

    override fun onBindViewHolder(holder: Holder, position: Int) =
        holder.bind(list[position], onClickListener)

    override fun getItemCount(): Int = list.size
}