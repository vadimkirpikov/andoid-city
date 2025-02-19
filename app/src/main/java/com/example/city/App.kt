import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.city.NavigationMenu
import com.example.city.screens.PlaceDetailsScreen
import com.example.city.screens.PlacesScreen
import com.example.city.screens.WelcomeScreen

@Composable
fun App(viewModel: MainViewModel) {
    val navController = rememberNavController()

    val screenWidth = LocalConfiguration.current.screenWidthDp

    if (screenWidth >= 600) {
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationMenu(navController, viewModel, true)
            Column(modifier = Modifier.weight(1F).fillMaxHeight()) {
                NavHost(navController, startDestination = "categories") {
                    composable("categories") { WelcomeScreen() }
                    composable("places") { PlacesScreen(navController, viewModel) }
                    composable("details") { PlaceDetailsScreen(navController, viewModel) }
                }
            }
        }
    }
    else {
        Column (modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.weight(1F).fillMaxHeight()) {
                NavHost(navController, startDestination = "categories") {
                    composable("categories") { WelcomeScreen() }
                    composable("places") { PlacesScreen(navController, viewModel) }
                    composable("details") { PlaceDetailsScreen(navController, viewModel) }
                }
            }
            NavigationMenu(navController, viewModel, false)

        }
    }
}
