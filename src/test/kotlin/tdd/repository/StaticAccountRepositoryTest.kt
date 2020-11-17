package tdd.repository

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import tdd.domain.Account
import tdd.exception.NotFoundException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StaticAccountRepositoryTest {

    private val repository: AccountRepository = StaticAccountRepository()

    private lateinit var account: Account

    @BeforeEach
    fun setup() {
        account = Account()
        repository.save(account)
    }

    @Test
    fun `should to save an account`() {
        val accountSaved = repository.save(account)
        assertEquals(accountSaved, account)
    }

    @Test
    fun `should to find an account`() {
        val accountFound = repository.find(account.id)
        assertEquals(account, accountFound)
    }

    @Test
    fun `should throw an exception when account not found`() {
        assertFailsWith<NotFoundException> {
            repository.find("notExist")
        }
    }

    @Test
    fun `should to update an account`() {
        account.amount = 10.0

        repository.save(account)

        val accountFound = repository.find(account.id)

        assertEquals(account.id, accountFound.id)
        assertEquals(10.0, accountFound.amount)
    }
}