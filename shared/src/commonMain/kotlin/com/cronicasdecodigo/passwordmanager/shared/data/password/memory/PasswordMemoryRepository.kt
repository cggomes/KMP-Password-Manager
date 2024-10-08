package com.cronicasdecodigo.passwordmanager.shared.data.password.memory

import com.cronicasdecodigo.passwordmanager.shared.data.password.PasswordRepository
import com.cronicasdecodigo.passwordmanager.shared.data.password.model.Password

class PasswordMemoryRepository : PasswordRepository {

    private val passwords = mutableListOf(
        Password(
            id = 1,
            title = "GitHub",
            username = "cggomes",
            password = "12345",
            url = "https://github.com",
            appLogo = "https://raw.githubusercontent.com/rdimascio/icons/master/icons/github.svg"
        )
    )

    override fun savePassword(
        title: String,
        username: String,
        password: String,
        url: String,
        appLogo: String,
    ) {
        val id = passwords.last().id + 1
        val passwordData = Password(
            id = id,
            title = title,
            username = username,
            password = password,
            url = url,
            appLogo = appLogo
        )
        passwords.add(passwordData)
    }

    override fun getPassword(id: Int): Password? = passwords.firstOrNull { it.id == id }

    override fun getPasswords(): List<Password> = passwords
}