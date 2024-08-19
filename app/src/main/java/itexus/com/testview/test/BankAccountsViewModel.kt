package itexus.com.testview.test

import androidx.lifecycle.ViewModel
import com.itexus.test.useCase.CreateBankAccountUseCase
import com.itexus.test.useCase.GetBankAccountsUseCase
import com.itexus.test.useCase.UnlinkBankAccountUseCase

class BankAccountsViewModel(
    private val getBankAccountsUseCase: GetBankAccountsUseCase,
    private val createBankAccountUseCase: CreateBankAccountUseCase,
    private val unlinkBankAccountUseCase: UnlinkBankAccountUseCase,
) : ViewModel()
