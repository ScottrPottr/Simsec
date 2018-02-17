package tech.simsec.android.view.accounts

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_account.view.*
import tech.simsec.android.ColorGenerator
import tech.simsec.android.R
import tech.simsec.android.view.TextDrawable

class AccountsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var fancyCircle = itemView.accountFancyCircle
    var name = itemView.accountName
    var address = itemView.accountAddress
}

class AccountsListAdapter : PagedListAdapter<AccountListItem, AccountsListViewHolder>(AccountsListAdapter.Companion.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccountsListViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_account, parent, false)
        return AccountsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountsListViewHolder, position: Int) {
        val account = getItem(position)
        account?.let {
            holder.name.text = account.name
            holder.address.text = account.address
            val builder = TextDrawable.Builder()
            holder.fancyCircle.setBackgroundDrawable(builder.build(account.name[0].toString(), ColorGenerator.MATERIAL.randomColor))
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffCallback<AccountListItem>() {
            override fun areItemsTheSame(oldItem: AccountListItem, newItem: AccountListItem): Boolean {
                return oldItem.address == newItem.address
            }

            override fun areContentsTheSame(oldItem: AccountListItem, newItem: AccountListItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}