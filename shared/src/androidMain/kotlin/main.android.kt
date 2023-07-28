import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

actual fun getPlatformName(): String = "Android"

@Preview
@Composable fun MainView() = App()
