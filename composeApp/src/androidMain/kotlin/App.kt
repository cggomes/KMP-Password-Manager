import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cronicasdecodigo.passwordmanager.ui.navigation.AppNavigation.CreatePassword
import com.cronicasdecodigo.passwordmanager.ui.navigation.AppNavigation.Password
import com.cronicasdecodigo.passwordmanager.ui.screens.create.CreatePasswordScreen
import com.cronicasdecodigo.passwordmanager.ui.screens.password.PasswordScreen
import com.cronicasdecodigo.passwordmanager.ui.screens.password.PasswordViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val passwordViewModel: PasswordViewModel = viewModel(factory = PasswordViewModel.Factory)
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Password) {
            composable<Password> {
                PasswordScreen(passwordViewModel = passwordViewModel) {
                    navController.navigate(route = CreatePassword)
                }
            }
            composable<CreatePassword> {
                CreatePasswordScreen(
                    viewModel = passwordViewModel,
                    onNavigateBack = { navController.navigateUp() },
                    onSavePassword = { navController.navigateUp() }
                )
            }
        }
    }
}

