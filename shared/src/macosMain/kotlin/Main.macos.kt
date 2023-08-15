import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

fun main() {
    NSApplication.sharedApplication()
    Window("Compose/Native sample") {
        App()
    }
    NSApp?.run()
}

actual fun getPlatformName(): String = "MacOS"