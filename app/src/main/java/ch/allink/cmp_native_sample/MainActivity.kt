package ch.allink.cmp_native_sample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ch.allink.cmp_native_sample.ui.theme.CmpNativeAndroidSampleTheme
import ch.allink.sample_cmp_app.ComposeActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CmpNativeAndroidSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(name = "From native compose view!",
                        modifier = Modifier.padding(innerPadding),
                        onButtonClick = {
                            val intent = Intent(this, ComposeActivity::class.java)
                            startActivity(intent)
                        })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onButtonClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello $name!",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Button(
                onClick = onButtonClick
            ) {
                Text(text = "To Compose Activity")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CmpNativeAndroidSampleTheme {
        Greeting(name = "Android", onButtonClick = {})
    }
}
