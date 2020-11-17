package tdd.domain

import tdd.exception.StatusNotAllowedException
import tdd.exception.ValueToOperationException
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
        validateValue(value)
        validateStatus()
        amount += value
        repository.save(this)
    }

    override fun withdraw(repository: AccountRepository, value: Double) {
        TODO("Not yet implemented")
    }

    private fun validateValue(value: Double) {
        if (value <= 0)
            throw ValueToOperationException("Value $value isn't allowed to execute this operation!")
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
