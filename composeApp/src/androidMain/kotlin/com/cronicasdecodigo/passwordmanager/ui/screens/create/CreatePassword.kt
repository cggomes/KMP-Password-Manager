package com.cronicasdecodigo.passwordmanager.ui.screens.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cronicasdecodigo.passwordmanager.R
import com.cronicasdecodigo.passwordmanager.shared.data.password.memory.PasswordMemoryRepository
import com.cronicasdecodigo.passwordmanager.ui.screens.password.PasswordViewModel

@Composable
fun CreatePasswordScreen(
    viewModel: PasswordViewModel,
    onNavigateBack: () -> Unit,
    onSavePassword: () -> Unit,
) {
    val state by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        IconButton(onClick = { onNavigateBack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = stringResource(R.string.go_back)
            )
        }
        Text(
            text = stringResource(R.string.add_password),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value = state.password.title,
            placeholder = { Text(text = stringResource(R.string.app)) },
            onValueChange = { viewModel.updateTitle(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = state.password.username,
            placeholder = { Text(text = stringResource(R.string.username)) },
            onValueChange = { viewModel.updateUsername(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = state.password.password,
            placeholder = { Text(text = stringResource(R.string.password)) },
            onValueChange = { viewModel.updatePassword(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = state.password.url,
            placeholder = { Text(text = stringResource(R.string.app_site)) },
            onValueChange = { viewModel.updateUrl(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = state.password.appLogo,
            placeholder = { Text(text = stringResource(R.string.app_logo)) },
            onValueChange = { viewModel.updateAppLogo(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Button(
                onClick = {
                    viewModel.savePassword()
                    onSavePassword()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.save))
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CreatePasswordScreenPreview() {
    CreatePasswordScreen(
        viewModel = PasswordViewModel(
            passwordRepository = PasswordMemoryRepository(),
        ),
        onNavigateBack = {}
    ) {}
}