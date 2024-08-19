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
    ),
    val searchTerm: String = "",
    val passwords: List<Password> = emptyList()
)

class PasswordViewModel(
    private val passwordRepository: PasswordRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<PasswordState> = MutableStateFlow(PasswordState())
    val uiState: StateFlow<PasswordState> = _uiState.asStateFlow()

    init {
        _uiState.value = _uiState.value.copy(passwords = getPasswords())
    }

    private fun getPasswords() : List<Password> = passwordRepository.getPasswords()

    fun updateTitle(title: String) {
        _uiState.value = _uiState.value.copy(
            password = _uiState.value.password.copy(title = title)
        )
    }

    fun updateUsername(username: String) {
        _uiState.value = _uiState.value.copy(
            password = _uiState.value.password.copy(username = username)
        )
    }

    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(
            password = _uiState.value.password.copy(password = password)
        )
    }

    fun updateUrl(url: String) {
        _uiState.value = _uiState.value.copy(
            password = _uiState.value.password.copy(url = url)
        )
    }

    fun updateAppLogo(appLogo: String) {
        _uiState.value = _uiState.value.copy(
            password = _uiState.value.password.copy(appLogo = appLogo)
        )
    }

    fun onSearchTermChange(searchTerm: String) {
        updateSearchTerm(searchTerm)
        filterPasswordList()
    }

    private fun updateSearchTerm(searchTerm: String) {
        _uiState.value = _uiState.value.copy(searchTerm = searchTerm)
    }

    private fun filterPasswordList() {
        _uiState.value = _uiState.value.copy(
            passwords = getPasswords().filter {
                it.title.lowercase().contains(_uiState.value.searchTerm.lowercase())
            }
        )
    }

    fun onSave() {
        savePassword()
        resetPasswordFields()
    }

    private fun savePassword() {
        val password = _uiState.value.password
        passwordRepository.savePassword(
            title = password.title,
            username = password.username,
            password = password.password,
            url = password.url,
            appLogo = password.appLogo
        )
    }

    private fun resetPasswordFields() {
        _uiState.value = _uiState.value.copy(
            password = Password(
                id = 0,
                title = "",
                username = "",
                password = "",
                url = "",
                appLogo = ""
            )
        )
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