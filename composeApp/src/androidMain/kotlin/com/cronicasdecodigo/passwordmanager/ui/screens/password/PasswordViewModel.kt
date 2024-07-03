package com.cronicasdecodigo.passwordmanager.ui.screens.password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cronicasdecodigo.passwordmanager.shared.data.password.PasswordRepository
import com.cronicasdecodigo.passwordmanager.shared.data.password.memory.PasswordMemoryRepository
import com.cronicasdecodigo.passwordmanager.shared.data.password.model.Password

class PasswordViewModel(
    private val passwordRepository: PasswordRepository,
) : ViewModel() {

    fun getPasswords() : List<Password> = passwordRepository.getPasswords()

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                PasswordViewModel(
                    passwordRepository = PasswordMemoryRepository()
                )
            }
        }
    }

}