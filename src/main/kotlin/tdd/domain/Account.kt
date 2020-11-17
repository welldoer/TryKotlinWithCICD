package tdd.domain

import tdd.exception.StatusNotAllowedException
import tdd.repository.AccountRepository
import java.util.*

data class Account(
    val id: String = UUID.randomUUID().toString(),
    val status: Status = Status.ACTIVE,
) : BaseAccount {

    var amount: Double = 0.0

    override fun create(repository: AccountRepository) {
        repository.save(this)
    }

    override fun deposit(repository: AccountRepository, value: Double) {
        validateStatus()
        amount += value
        repository.save(this)
    }

    override fun withdraw(repository: AccountRepository, value: Double) {
        TODO("Not yet implemented")
    }

    private fun validateStatus() {
        if (status != Status.ACTIVE)
            throw StatusNotAllowedException("DEPOSIT", status.name)
    }

    enum class Status {
        ACTIVE,
        INACTIVE,
    }

}
