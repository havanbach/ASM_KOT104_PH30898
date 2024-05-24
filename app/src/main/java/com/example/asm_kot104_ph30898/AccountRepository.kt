package com.example.asm_kot104_ph30898.repository

import com.example.asm_kot104_ph30898.Account

object AccountRepository {
    private val accounts = mutableListOf<Account>()

    fun addAccount(account: Account) {
        accounts.add(account)
    }

    fun validateAccount(email: String, password: String): Boolean {
        return accounts.any { it.email == email && it.password == password }
    }

    fun getAccountByEmail(email: String): Account? {
        return accounts.find { it.email == email }
    }
}
