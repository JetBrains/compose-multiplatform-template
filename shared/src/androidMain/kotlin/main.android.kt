import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()

@Preview
@Composable
fun SharedPreview() {
    Text("Hello shared Preview on Android")
}
