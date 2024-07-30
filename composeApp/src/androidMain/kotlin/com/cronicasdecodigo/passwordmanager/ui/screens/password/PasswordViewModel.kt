package com.cronicasdecodigo.passwordmanager.ui.screens.password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cronicasdecodigo.passwordmanager.shared.data.password.PasswordRepository
import com.cronicasdecodigo.passwordmanager.shared.data.password.memory.PasswordMemoryRepository
import com.cronicasdecodigo.passwordmanager.shared.data.password.model.Password
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PasswordState(
    val password: Password = Password(
        id = 0,
        title = "",
        username = "",
        password = "",
        url = "",
        appLogo = ""
    )
)

class PasswordViewModel(
    private val passwordRepository: PasswordRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<PasswordState> = MutableStateFlow(PasswordState())
    val uiState: StateFlow<PasswordState> = _uiState.asStateFlow()

    fun getPasswords() : List<Password> = passwordRepository.getPasswords()

    fun updateTitle(title: String) {
        _uiState.value = PasswordState(
            _uiState.value.password.copy(title = title)
        )
    }

    fun updateUsername(username: String) {
        _uiState.value = PasswordState(
            _uiState.value.password.copy(username = username)
        )
    }

    fun updatePassword(password: String) {
        _uiState.value = PasswordState(
            _uiState.value.password.copy(password = password)
        )
    }

    fun updateUrl(url: String) {
        _uiState.value = PasswordState(
            _uiState.value.password.copy(url = url)
        )
    }

    fun updateAppLogo(appLogo: String) {
        _uiState.value = PasswordState(
            _uiState.value.password.copy(appLogo = appLogo)
        )
    }

    fun savePassword() {
        val password = _uiState.value.password
        passwordRepository.savePassword(
            title = password.title,
            username = password.username,
            password = password.password,
            url = password.url,
            appLogo = password.appLogo
        )
        resetPasswordFields()
    }

    private fun resetPasswordFields() {
        _uiState.value = PasswordState()
    }

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