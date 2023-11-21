import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    var questionsProgress by remember { mutableStateOf(0) }

    MaterialTheme {
        val quiz =  Quiz(listOf(
            Question(
                1,
                "Android is a great platform ?",
                1,
                listOf(Answer(1, "YES"), Answer(2, "NO"), Answer(3, "HIHIHI"))
            ),
            Question(
                1,
                "Android is a bad platform ?",
                2,
                listOf(Answer(1, "YES"), Answer(2, "NO"))
            )
        ))
        //WelcomeScreen()
        //ScoreScreen("10/20")
        questionScreen(quiz)
    }
}


expect fun getPlatformName(): String