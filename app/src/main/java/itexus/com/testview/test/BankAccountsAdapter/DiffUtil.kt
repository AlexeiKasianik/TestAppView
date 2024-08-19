package itexus.com.testview.test.BankAccountsAdapter

import androidx.recyclerview.widget.DiffUtil

val diffUtil = object : DiffUtil.ItemCallback<BankAccountsModel>() {
    override fun areItemsTheSame(
        oldItem: BankAccountsModel,
        newItem: BankAccountsModel,
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: BankAccountsModel,
        newItem: BankAccountsModel,
    ) = oldItem == newItem
}