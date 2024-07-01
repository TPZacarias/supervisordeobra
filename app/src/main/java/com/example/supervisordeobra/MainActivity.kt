package com.example.supervisordeobra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.supervisordeobra.telas.balacoDeMassa
import com.example.supervisordeobra.telas.grauDeCompactacao
import com.example.supervisordeobra.telas.supervisao
import com.example.supervisordeobra.telas.telaInicial
import com.example.supervisordeobra.telas.telaincerirArquivo
import com.example.supervisordeobra.ui.theme.SupervisorDeObraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupervisorDeObraTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "telaInicial" ){
                    composable("telaInicial"){
                        telaInicial(navController)
   //                         navController.navigate("telaInciraArquivo")

                    }
                    composable("telaincerirArquivo"){
                        telaincerirArquivo(navController)
                    }
                    composable("supervisor"){
                        supervisao(navController)
                    }
                    composable("balacoDeMassa"){
                        balacoDeMassa(navController)
                    }
                    composable("grauDeCompactacao"){
                        grauDeCompactacao(navController)
                    }
                }
                    }
                }
            }
        }



