package com.itexus.test.useCase

import com.github.michaelbull.result.Ok
import com.itexus.test.useCase.dto.GetBankAccountsModel
import com.github.michaelbull.result.Result
import com.itexus.test.useCase.dto.BankAccountStatus
import kotlin.random.Random

class GetBankAccountsUseCase {
    suspend operator fun invoke(): Result<List<GetBankAccountsModel>, RuntimeException> {
        return Ok(
            mutableListOf(
                GetBankAccountsModel(
                    id = Random.nextInt().toString(),
                    name = Random.nextInt().toString(),
                    lastFourDigits = Random.nextInt().toString(),
                    status = BankAccountStatus.APPROVED),
                GetBankAccountsModel(
                    id = Random.nextInt().toString(),
                    name = Random.nextInt().toString(),
                    lastFourDigits = Random.nextInt().toString(),
                    status = BankAccountStatus.CLOSED),
            )
        )
    }
}
