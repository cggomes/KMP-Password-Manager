package com.cronicasdecodigo.passwordmanager.shared.data.password.memory

import com.cronicasdecodigo.passwordmanager.shared.data.password.PasswordRepository
import com.cronicasdecodigo.passwordmanager.shared.data.password.model.Password

class PasswordMemoryRepository : PasswordRepository {

    private val passwords = mutableListOf<Password>(
        Password(
            id = 1,
            title = "GitHub",
            username = "cggomes",
            password = "12345",
            url = "https://github.com/cggomes"
        )
    )

    override fun savePassword(
        id: Int,
        title: String,
        username: String,
        password: String,
        url: String
    ) {
        val passwordData = Password(
            id = id,
            title = title,
            username = username,
            password = password,
            url = url,
        )
        passwords.add(passwordData)
    }

    override fun getPassword(id: Int): Password? = passwords.firstOrNull { it.id == id }

    override fun getPasswords(): List<Password> = passwords
}