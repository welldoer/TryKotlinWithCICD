package tdd.repository

import tdd.domain.Account
import tdd.exception.NotFoundException

class StaticAccountRepository : AccountRepository {
    private val accounts = mutableMapOf<String, Account>()

    override fun save(account: Account): Account {
        accounts[account.id] = account
        return account
    }

    override fun find(id: String): Account {
        return accounts[id] ?: throw NotFoundException(Account::class.java.simpleName, id)
    }

}