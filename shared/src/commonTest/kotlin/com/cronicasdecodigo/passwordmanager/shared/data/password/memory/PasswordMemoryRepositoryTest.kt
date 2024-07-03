package com.cronicasdecodigo.passwordmanager.shared.data.password.memory

import com.cronicasdecodigo.passwordmanager.shared.data.password.PasswordRepository
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class PasswordMemoryRepositoryTest : FreeSpec ({
    lateinit var passwordRepository: PasswordRepository

    beforeTest {
        passwordRepository = PasswordMemoryRepository()
    }

    "should save title, password, username and url" - {
        passwordRepository.savePassword(
            id = 1,
            title = "GitHub",
            username = "cggomes",
            password = "password",
            url = "https://github.com",
        )
        val passwordData = passwordRepository.getPassword(1)
        passwordData shouldNotBe null
        passwordData?.id shouldBe 1
        passwordData?.title shouldBe "GitHub"
        passwordData?.username shouldBe "cggomes"
        passwordData?.password shouldBe "password"
        passwordData?.url shouldBe "https://github.com"
    }
})