package com.cronicasdecodigo.passwordmanager.ui.components.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cronicasdecodigo.passwordmanager.R
import com.cronicasdecodigo.passwordmanager.shared.data.password.model.Password

@Composable
fun PasswordList(
    passwords: List<Password>,
    onPasswordSelected: (Password) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(passwords, key = { it.id }) { password ->
            PasswordItem(
                password = password,
                onClick = { onPasswordSelected(password) },
            )
        }
    }
}

@Composable
fun PasswordItem(
    password: Password,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onClick() }
            .padding(8.dp)
            .height(60.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = password.title
        )
        Column {
            Text(text = password.title, style = MaterialTheme.typography.subtitle1)
            Text(text = password.username, style = MaterialTheme.typography.caption)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "...",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.Top)
        )
    }
}

@Composable
@Preview(name = "PasswordListPreview", showSystemUi = true, showBackground = true)
fun PasswordListPreview() {
    PasswordList(
        passwords = listOf(
            Password(
                id = 1,
                title = "GitHub",
                username = "cggomes",
                password = "123456",
                url = "https://github.com"
            )
        ),
        onPasswordSelected = { println("Password selected $it") }
    )
}
