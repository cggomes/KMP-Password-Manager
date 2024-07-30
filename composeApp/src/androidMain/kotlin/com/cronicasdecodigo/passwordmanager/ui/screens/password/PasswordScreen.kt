package com.cronicasdecodigo.passwordmanager.ui.screens.password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cronicasdecodigo.passwordmanager.R
import com.cronicasdecodigo.passwordmanager.shared.data.password.memory.PasswordMemoryRepository
import com.cronicasdecodigo.passwordmanager.ui.components.list.PasswordList

@Composable
fun PasswordScreen(
    passwordViewModel: PasswordViewModel,
    onNavigateToCreate: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        IconButton(onClick = { onNavigateToCreate() }) {
            Icon(
                imageVector = Icons.Outlined.AddCircle,
                contentDescription = stringResource(R.string.add_new_password_item),
            )
        }
        Text(
            text = stringResource(R.string.password_title),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        PasswordList(
            passwords = passwordViewModel.getPasswords(),
            onPasswordSelected = {}
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PasswordScreenPreview() {
    val passwordViewModel = PasswordViewModel(PasswordMemoryRepository())
    PasswordScreen(passwordViewModel = passwordViewModel) {}
}
