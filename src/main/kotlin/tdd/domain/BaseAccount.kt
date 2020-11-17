package tdd.domain

import tdd.repository.AccountRepository

interface BaseAccount {

    fun create(repository: AccountRepository)

    fun deposit(repository: AccountRepository, value: Double)

    fun withdraw(repository: AccountRepository, value: Double)
}
