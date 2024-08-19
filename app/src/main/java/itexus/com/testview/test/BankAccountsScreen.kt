package itexus.com.testview.test

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.itexus.test.useCase.CreateBankAccountUseCase
import com.itexus.test.useCase.GetBankAccountsUseCase
import com.itexus.test.useCase.UnlinkBankAccountUseCase
import itexus.com.testview.R
import itexus.com.testview.databinding.BankAccountsScreenBinding

class BankAccountsScreen : Fragment(R.layout.bank_accounts_screen) {

    private val binding by viewBinding(BankAccountsScreenBinding::bind)
    private val viewModel = BankAccountsViewModel(
        getBankAccountsUseCase = GetBankAccountsUseCase(),
        createBankAccountUseCase = CreateBankAccountUseCase(),
        unlinkBankAccountUseCase = UnlinkBankAccountUseCase(),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun Context.showAlertDialog(
        accountId: String,
        onPositiveClick: (String) -> Unit = {},
        onNegativeClick: () -> Unit = {}
    ) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Удаление")
        builder.setMessage("Удалить аккаунт $accountId?")
        builder.setPositiveButton("Да") { dialogInterface, i ->
            onPositiveClick(accountId)
        }
        builder.setNegativeButton("Нет") { dialogInterface, i ->
            onNegativeClick()
        }
        builder.show()
    }
}
