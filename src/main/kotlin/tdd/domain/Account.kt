package tdd.domain

import tdd.repository.AccountRepository
import java.util.*

data class Account(
    val id: String = UUID.randomUUID().toString(),
) : BaseAccount {
    var amount: Double = 0.0

    override fun create(repository: AccountRepository) {
        repository.save(this)
    }

    override fun deposit(repository: AccountRepository, value: Double) {
        TODO("Not yet implemented")
    }

    override fun withdraw(repository: AccountRepository, value: Double) {
        TODO("Not yet implemented")
    }
}
