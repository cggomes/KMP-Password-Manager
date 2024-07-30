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

    "should retrieve default password with correct title, password, username, url and appLogo" - {
        val passwordData = passwordRepository.getPassword(1)
        passwordData shouldNotBe null
        passwordData?.id shouldBe 1
        passwordData?.title shouldBe "GitHub"
        passwordData?.username shouldBe "cggomes"
        passwordData?.password shouldBe "12345"
        passwordData?.url shouldBe "https://github.com"
        passwordData?.appLogo shouldBe "https://raw.githubusercontent.com/rdimascio/icons/master/icons/github.svg"
    }

    "should save new password with title, password, username, url and appLogo" - {
        passwordRepository.savePassword(
            title = "Google",
            username = "christian",
            password = "password",
            url = "https://google.com",
            appLogo = "https://raw.githubusercontent.com/rdimascio/icons/master/icons/google.svg"
        )
        val passwordData = passwordRepository.getPassword(2)
        passwordData shouldNotBe null
        passwordData?.id shouldBe 2
        passwordData?.title shouldBe "Google"
        passwordData?.username shouldBe "christian"
        passwordData?.password shouldBe "password"
        passwordData?.url shouldBe "https://google.com"
        passwordData?.appLogo shouldBe "https://raw.githubusercontent.com/rdimascio/icons/master/icons/google.svg"
    }
})