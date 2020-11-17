package tdd.repository

import tdd.domain.Account

interface AccountRepository {

    fun save(account: Account): Account

    fun find(id: String): Account

//    fun delete(id: String)
}
