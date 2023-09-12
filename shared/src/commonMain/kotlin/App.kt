import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    test()
}

@Composable
fun test(qualifiers: Test = Test(0)): String = "test"