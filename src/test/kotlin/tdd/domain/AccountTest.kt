package tdd.domain

import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import tdd.exception.StatusNotAllowedException
import tdd.exception.ValueToOperationException
import tdd.repository.AccountRepository
import kotlin.test.assertFailsWith

@ExtendWith(MockKExtension::class)
class AccountTest {

    @RelaxedMockK
    lateinit var repository: AccountRepository

    @Test
    fun `verify if account repository was called to create an account`() {
        val account = Account()

        account.create(repository)

        verify(exactly = 1) { repository.save(account) }
    }

    @Test
    fun `should deposit any value an account`() {
        val account = Account()
        account.deposit(repository, 10.0)

        verify(exactly = 1) { repository.save(account) }
    }

    @Test
    fun `shouldn't deposit when status is inactive`() {
        val account = Account(status = Account.Status.INACTIVE)

        assertFailsWith<StatusNotAllowedException> {
            account.deposit(repository, 10.0)
        }
    }

    @Test
    fun `shouldn't deposit when the value is negative`() {
        val account = Account()

        assertFailsWith<ValueToOperationException> {
            account.deposit(repository, -10.0)
        }
    }
}