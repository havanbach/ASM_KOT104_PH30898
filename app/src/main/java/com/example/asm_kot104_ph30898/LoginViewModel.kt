package com.example.asm_kot104_ph30898.viewmodel

import androidx.lifecycle.ViewModel
import com.example.asm_kot104_ph30898.Account
import com.example.asm_kot104_ph30898.repository.AccountRepository

class LoginViewModel : ViewModel() {
    private val accountRepository = AccountRepository

    fun addAccount(account: Account) {
        accountRepository.addAccount(account)
    }

    fun validateAccount(email: String, password: String): Boolean {
        return accountRepository.validateAccount(email, password)
    }

    fun getAccountByEmail(email: String): Account? {
        return accountRepository.getAccountByEmail(email)
    }
}
