package com.example.questuserinput_039

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.questuserinput_039.ui.theme.QuestUserInput_039Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestUserInput_039Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 🔹 Panggil fungsi FormRegistrasi() di sini
                    FormRegistrasi()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormRegistrasiPreview() {
    QuestUserInput_039Theme {
        FormRegistrasi()
    }
}
