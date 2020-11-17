package tdd.domain

import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import tdd.repository.AccountRepository

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
}