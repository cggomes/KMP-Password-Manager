package com.cronicasdecodigo.passwordmanager.shared.data.password

import com.cronicasdecodigo.passwordmanager.shared.data.password.model.Password

interface PasswordRepository {
    fun savePassword(
        id: Int,
        title: String,
        username: String,
        password: String,
        url: String,
        appLogo: String,
    )

    fun getPassword(id: Int): Password?

    fun getPasswords(): List<Password>
}

