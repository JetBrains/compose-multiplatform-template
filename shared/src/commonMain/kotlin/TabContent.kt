import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Tab.TabContent() {
    val tabTitle = options.title

    LifecycleEffect(
        onStarted = {
            //Log.d("Navigator", "Start tab $tabTitle")
                    },
        onDisposed = {
            //Log.d("Navigator", "Dispose tab $tabTitle")
            },
    )

    Navigator(screen = BasicNavigationScreen(index = 0)) { navigator ->
        //SlideTransition(navigator) { screen ->
            Column {
                InnerTabNavigation()
                //screen.Content()
                println("Navigator Last Event: ${navigator.lastEvent}")
            }
        //}
    }
}

@Composable
private fun InnerTabNavigation() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        TabNavigationButton(HomeTab)

        Spacer(modifier = Modifier.weight(.05f))

        TabNavigationButton(FavoritesTab)

        Spacer(modifier = Modifier.weight(.05f))

        TabNavigationButton(ProfileTab)
    }
}

@Composable
private fun RowScope.TabNavigationButton(
    tab: Tab
) {
    val tabNavigator = LocalTabNavigator.current

    Button(
        enabled = tabNavigator.current.key != tab.key,
        onClick = { tabNavigator.current = tab },
        modifier = Modifier.weight(1f)
    ) {
        Text(text = tab.options.title)
    }
}