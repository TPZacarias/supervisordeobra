package com.example.supervisordeobra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.supervisordeobra.ui.theme.SupervisorDeObraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupervisorDeObraTheme {
                Navegar()
            }
        }
    }
}

