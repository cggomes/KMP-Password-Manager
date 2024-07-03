import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cronicasdecodigo.passwordmanager.ui.screens.password.PasswordScreen
import com.cronicasdecodigo.passwordmanager.shared.data.password.memory.PasswordMemoryRepository
import com.cronicasdecodigo.passwordmanager.ui.screens.password.PasswordViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val passwordViewModel: PasswordViewModel = viewModel(factory = PasswordViewModel.Factory)
        PasswordScreen(passwordViewModel = passwordViewModel)
    }
}

